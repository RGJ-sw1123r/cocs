package com.korbiztech.product.cocs.CM.BG.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.korbiztech.product.cocs.CM.BG.dao.BGA030_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA030_VO;
import com.korbiztech.product.cocs.CM.BG.vo.paramVO;
import com.korbiztech.product.cocs.COM.service.Common_Service;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.Pair;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.FileParamsVO;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BGA030_Service {
    
	@Autowired
	private Common_Service commonService;
	 
    @Autowired
    private BGA030_DAO bgaDAO;
    
    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private ProfileChecker profileChecker;

    public List<HashMap<String, ?>> selectSite() {
        return bgaDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectChsu(paramVO params) {
        return bgaDAO.selectChsu(params);
    }
    
    public List<HashMap<String, ?>> selectParentGrid(paramVO params) {
        return bgaDAO.selectParentGrid(params);
    }

    public List<HashMap<String, ?>> selectChildGrid(paramVO params) {
        return bgaDAO.selectChildGrid(params);
    }
    
    public List<HashMap<String, ?>> selectThreeTree(paramVO params) {
        return bgaDAO.selectThreeTree(params);
    }

    public List<HashMap<String, ?>> selectFourTree(paramVO params) {
        return bgaDAO.selectFourTree(params);
    }

    public List<HashMap<String, ?>> selectGogu(paramVO params) {
        return bgaDAO.selectGogu(params);
    }

    public List<HashMap<String, ?>> selectAddGJ(paramVO params) {
        return bgaDAO.selectAddGJ(params);
    }
    
    public List<HashMap<String, ?>> selectAddItem(paramVO params) {
        return bgaDAO.selectAddItem(params);
    }

    public List<HashMap<String, ?>> selectGubu() {
        return bgaDAO.selectGubu();
    }

    public List<HashMap<String, ?>> selectDivideItem(paramVO params) {
        return bgaDAO.selectDivideItem(params);
    }

    public void insertAddGJ(paramVO params) {
        bgaDAO.insertAddGJ(params);
    }

    public void insertDivideItems(paramVO params) {
        bgaDAO.insertDivideItems(params);
    }

    @SuppressWarnings("rawtypes")
	@Transactional
    public ResponseEntity<?> saveGridData(HttpServletRequest request, String gridId) {
        String jsonString = jsonUtil.readJsonStringFromRequest(request);
        ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);
        if (errorResponse != null) {
            System.out.println(errorResponse);
            return errorResponse;
        } else {
            List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
            List<BGA030_VO> updateList = new ArrayList<>();
            List<BGA030_VO> insertList = new ArrayList<>();
            List<BGA030_VO> deleteList = new ArrayList<>();

            for (SaveGridDataVO item : voList) {
            	Object data = item.getData();
            	BGA030_VO vo = JsonUtil.convertAndSanitize(data, BGA030_VO.class);
                switch (item.getStatus()) {
                    case "u" -> updateList.add(vo);
                    case "i" -> insertList.add(vo);
                    case "d" -> deleteList.add(vo);
                }
            }
            boolean isDev = profileChecker.isDevProfileActive();
            try {
                switch (gridId) {
                    case "grid_01" -> {
                        if (updateList.size() > 0) {
                            bgaDAO.saveCategoryUpdateData1(updateList);
                        }
                        if (insertList.size() > 0 && bgaDAO.saveCategoryInsertData(insertList) != insertList.size()) {
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
                        }
                        if (deleteList.size() > 0 && bgaDAO.saveCategoryDeleteData(deleteList) != deleteList.size()) {
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
                        }
                    }
                    case "grid_02" -> {
                        if (updateList.size() > 0) {
                            bgaDAO.saveCategoryUpdateData2(updateList);
                        }
                    }
                    case "grid_04" -> {
                        if (updateList.size() > 0) {
                            bgaDAO.saveDivideItems(updateList);
                        }
                    }
                }
                HashMap<String, Object> response = new HashMap<>();
                response.put("messege", "Ajax saveGridData success");
                response.put("updatedCount", updateList.size());
                response.put("insertedCount", insertList.size());
                response.put("deletedCount", deleteList.size());
                return new ResponseEntity<>(response, HttpStatus.OK);
                
            } catch (DataAccessException e) {
				if (isDev) {
					e.printStackTrace();
				}
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Operation Failure: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				if (isDev) {
					e.printStackTrace();
				}
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Argument: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error Occurred: " + e.getMessage());
            }
        }
    }

    public ResponseEntity<?> uploadFiles(List<MultipartFile> files, String paramsJson) {
    	Path uploadPath = Paths.get("uploads", "CM", "BG", "BGA030");
    	Optional<Pair<Boolean, List<FileParamsVO>>> uploadResult = commonService.uploadFiles(files, uploadPath, paramsJson);
    	if (uploadResult.isPresent() && uploadResult.get().getLeft()) {
    		List<FileParamsVO> fileParamsVO = uploadResult.get().getRight();
    		List<FileParamsVO> addFileParams = new ArrayList<>();
    		List<FileParamsVO> deleteFileParams = new ArrayList<>();
    		for (FileParamsVO param : fileParamsVO) {
    			switch (param.getStatus()) {
    				case "add" -> addFileParams.add(param);
    				case "delete" -> deleteFileParams.add(param);
    			}
    		}
    		if (addFileParams.size() > 0 && bgaDAO.addFiles(addFileParams) != addFileParams.size()) {
    			return new ResponseEntity<>("Adding files failed.", HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		if (deleteFileParams.size() > 0 && bgaDAO.deleteFiles(deleteFileParams) != deleteFileParams.size()) {
    			return new ResponseEntity<>("Deleting files failed.", HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		return new ResponseEntity<>("File processing succeeded.", HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("File upload failed.", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
