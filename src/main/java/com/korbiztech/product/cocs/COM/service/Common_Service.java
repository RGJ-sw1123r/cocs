package com.korbiztech.product.cocs.COM.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.reflect.TypeToken;
import com.korbiztech.product.cocs.COM.dao.Menu_DAO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.Pair;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.util.SecurityUtil;
import com.korbiztech.product.cocs.COM.vo.FileParamsVO;
import com.softbowl.poi.SBLoadExcel;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("common_Service")
public class Common_Service {

	@Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	@Autowired
	private Menu_DAO menuDao;

	public List<HashMap<String, ?>> getMenuList() {
		return menuDao.getMenuList();
	}

	public Optional<List<FileParamsVO>> validateAndParseJson(String paramsJson) {
		ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(paramsJson);
		if (errorResponse != null) {
			return Optional.empty();
		}
		List<FileParamsVO> fileParamsVO = JsonUtil.parseJsonToList(paramsJson, new TypeToken<List<FileParamsVO>>(){}.getType());
		return Optional.ofNullable(fileParamsVO);
	}

	public Optional<Pair<Boolean, List<FileParamsVO>>> uploadFiles(List<MultipartFile> files, Path uploadPath, String paramsJson) {
		Optional<List<FileParamsVO>> maybeFileParamsVO = validateAndParseJson(paramsJson);
		if (!maybeFileParamsVO.isPresent()) {
			return Optional.empty();
		}

		List<FileParamsVO> fileParamsVO = maybeFileParamsVO.get();

		String os = System.getProperty("os.name").toLowerCase();
		String rootDir = os.contains("win") ? "C:/" : "/";
		uploadPath = Paths.get(rootDir).resolve(uploadPath);

		try {
			Files.createDirectories(uploadPath);
		} catch (IOException e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
			log.error("Failed to create directories: {}", uploadPath, e);
			return Optional.empty();
		}

		for (MultipartFile file : files) {
			String originalFileName = file.getOriginalFilename();
			try {
				String uniqueFileName = generateUniqueFileName(originalFileName, uploadPath);
				Path filePath = uploadPath.resolve(uniqueFileName);
				Files.copy(file.getInputStream(), filePath);

				String hashedFilePath = filePath.toString().substring(rootDir.length());
				updateFileParamsVO(fileParamsVO, originalFileName, hashedFilePath);

				log.info("File saved at: {}", filePath.toAbsolutePath().toString());
			} catch (Exception e) {
				if (profileChecker.isDevProfileActive()) {
					e.printStackTrace();
				}
				log.error("An error occurred while processing the file: {}", originalFileName, e);
				return Optional.empty();
			}
		}
		return Optional.of(new Pair<>(true, fileParamsVO));
	}

	private String generateUniqueFileName(String originalFileName, Path uploadPath) throws NoSuchAlgorithmException, IOException {
		String randomStr, hashValue, uniqueFileName;
		Path filePath;
		do {
			randomStr = SecurityUtil.randomString(4);
			hashValue = SecurityUtil.generateHash(originalFileName + randomStr);
			uniqueFileName = randomStr + hashValue;
			filePath = uploadPath.resolve(uniqueFileName);
		} while (Files.exists(filePath));
		return uniqueFileName;
	}

	private void updateFileParamsVO(List<FileParamsVO> fileParamsVO, String originalFileName, String hashedFilePath) {
		for (FileParamsVO param : fileParamsVO) {
			if (param.getName().equals(originalFileName)) {
				param.setHashedFileName(hashedFilePath);
				log.trace("HashedFileName set for {}", originalFileName);
				break;
			}
		}
	}

	public ResponseEntity<?> SBExcelLoad(MultipartFile file, Map<String, String> allParams,
			HttpServletResponse response) {
		// 1. File validation on server side
		String originalFilename = file.getOriginalFilename();
		String fileExtension = FilenameUtils.getExtension(originalFilename);
		if (!"xlsx".equalsIgnoreCase(fileExtension)) {
			return new ResponseEntity<>("Invalid File Extension", HttpStatus.BAD_REQUEST);
		}
		
		// 2. File save on Disk
		String os = System.getProperty("os.name").toLowerCase();
		String rootDir = os.contains("win") ? "C:/" : "/";
		Path uploadPath = Paths.get(rootDir).resolve("upload/temp/importExcel");
		
		try {
			Files.createDirectories(uploadPath);
		} catch (IOException e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("Failed to create directories", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		try {
			Path filePath = uploadPath.resolve(originalFilename);
			Files.copy(file.getInputStream(), filePath);
		} catch (Exception e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("An error occurred while processing the file", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		// 3. File Parsing Logic
		JSONArray arrGridData = new JSONArray();
		JSONParser JSONdataParser = new JSONParser();
		File fExcel = null;
		
		try {
			String strFileInputName = allParams.get("SBHE___SB_FileInputName");
			String strTargetGrid = allParams.get("SBHE___SB_SBGridID");
			int nFixedRows = Integer.parseInt(allParams.get("SBHE___SB_FixedRows"));
			int nFixedCols = Integer.parseInt(allParams.get("SBHE___SB_FixedCols"));
			JSONArray arrRefs = (JSONArray)(JSONdataParser.parse(allParams.get("SBHE___SB_Refs")));
			String objDataFormat = allParams.get("SBHE___SB_ObjDataFormat") == null ? "" : allParams.get("SBHE___SB_ObjDataFormat").toString();
			
			JSONArray arrDataFormat = new JSONArray();
			if(objDataFormat != "") {
				arrDataFormat = (JSONArray)(JSONdataParser.parse(objDataFormat));
			}
			String strDataType = allParams.get("SBHE___SB_DataType");
			String strGridRef = allParams.get("SBHE___SB_Ref");
			
			Path filePath = uploadPath.resolve(originalFilename);
			fExcel = filePath.toFile();
			
			//대용량 엑셀 파일 업로드 가능하도록 SBLoadExcel class 사용
			System.out.println("Creating JSON DATA was Started.");
			
			SBLoadExcel loadExcel = new SBLoadExcel(arrRefs, nFixedRows, nFixedCols, arrDataFormat);
			loadExcel.read(fExcel);
			arrGridData = loadExcel.getGridData();
			
			System.out.println("Grid's Row DATA Count:" + arrGridData.size());
			System.out.println("Grid's Row DATA:" + arrGridData.toString());
			
			System.out.println("Creating JSON DATA was completed.");
			
			StringBuffer strHTML = new StringBuffer();
			strHTML.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><script type='text/javascript'>");
			strHTML.append("eval(\"var arrGridData = parent." + strGridRef + ";\");");
			strHTML.append("while(arrGridData.length){arrGridData.pop();}");
			sendResult(response, strHTML.toString(), "text/html", false);
			strHTML.delete(0, strHTML.length());
			
			for(int i = 1, nRowCount = arrGridData.size() ; i <= nRowCount ; i++) {
				strHTML.append("arrGridData.push(" + arrGridData.get(i - 1).toString() + ");");
				
				if(i % 2000 == 0){
					sendResult(response, strHTML.toString(), "text/html", false);
					strHTML.delete(0, strHTML.length());
				}
			}
			
			strHTML.append("eval(\"parent." + strTargetGrid + ".refresh();\");");
			strHTML.append("eval(\"parent." + strTargetGrid + ".dispatch('afterimportexcel');\");");
			strHTML.append("</script></head></html>");
			sendResult(response, strHTML.toString(), "text/html;", true);
			strHTML.delete(0, strHTML.length());
		} catch (Exception e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("An error occurred while processing the file", HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if (fExcel != null && fExcel.exists()) {
				fExcel.delete();
			}
			arrGridData.clear();
		}
		return new ResponseEntity<>("File successfully processed", HttpStatus.OK);
	}
	
	public void sendResult(HttpServletResponse response, String strRes, String strContentsType, boolean bIsClosed) {
		response.setContentType(strContentsType);
		response.setCharacterEncoding("UTF-8");
		PrintWriter objWriter = null;
		
		try {
			objWriter = response.getWriter();
			objWriter.print(strRes);
		} catch (IOException e) {
			if (profileChecker.isDevProfileActive()) {
				e.printStackTrace();
			}
		} finally {
			if (null != objWriter) {
				objWriter.flush();
			}
			if (bIsClosed) {
				objWriter.close();
			}
		}
	}
	
}
