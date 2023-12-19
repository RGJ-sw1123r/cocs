package com.korbiztech.product.cocs.SY.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;
import com.korbiztech.product.cocs.SY.dao.SAA060_DAO;
import com.korbiztech.product.cocs.SY.vo.SAA060_VO;

import jakarta.servlet.http.HttpServletRequest;

@Service("SAA060_Service")
public class SAA060_Service {

	@Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
    private JsonUtil jsonUtil;
	
	@Autowired
	private SAA060_DAO dao;

	@Transactional(readOnly = true)
	public List<HashMap<String, ?>> getGridData(String tabName) {
		return switch (tabName) {
			case "tab_01" -> dao.getCategoryGridData();
			case "tab_02" -> dao.getMajorCategoryGridData();
			case "tab_03" -> dao.getSubCategoryGridData();
			default -> throw new IllegalArgumentException("Invalid tab name: " + tabName);
		};
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public ResponseEntity<?> saveGridData(HttpServletRequest request, String tabName) {
		String jsonString = jsonUtil.readJsonStringFromRequest(request);
		ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);
		if (errorResponse != null) {
			return errorResponse;
		} else {
			List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
			List<SAA060_VO> updateList = new ArrayList<>();
			List<SAA060_VO> insertList = new ArrayList<>();
			List<SAA060_VO> deleteList = new ArrayList<>();

			for (SaveGridDataVO item : voList) {
				Object data = item.getData();
				Gson gson = new Gson();
				String jsonData = gson.toJson(data);
				SAA060_VO vo = gson.fromJson(jsonData, SAA060_VO.class);
				switch (item.getStatus()) {
					case "u" -> updateList.add(vo);
					case "i" -> insertList.add(vo);
					case "d" -> deleteList.add(vo);
				}
			}

			boolean isDev = profileChecker.isDevProfileActive();
			try {
				switch (tabName) {
					case "tab_01" -> {
						if (updateList.size() > 0) {
							dao.saveCategoryUpdateData(updateList);
			            }
			            if (insertList.size() > 0 && dao.saveCategoryInsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
			            if (deleteList.size() > 0 && dao.saveCategoryDeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_02" -> {
						//dao.saveMajorCategoryUpdateData(updateList);
						//dao.saveMajorCategoryInsertData(insertList);
						//dao.saveMajorCategoryDeleteData(deleteList);
					}
					case "tab_03" -> {
						//dao.saveSubCategoryUpdateData(updateList);
						//dao.saveSubCategoryInsertData(insertList);
						//dao.saveSubCategoryDeleteData(deleteList);
					}
					default -> throw new IllegalArgumentException("Invalid tab name: " + tabName);
				}

				HashMap<String, Object> response = new HashMap<>();
		        response.put("message", "Ajax saveGridData Success");
		        response.put("updatedCount", updateList.size());
		        response.put("insertedCount", insertList.size());
		        response.put("deletedCount", deleteList.size());
		        return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (DataAccessException e) {
				if (isDev) {
					e.printStackTrace();
				}
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			    		.body("Database Operation Failure: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				if (isDev) {
					e.printStackTrace();
				}
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			    		.body("Invalid Argument: " + e.getMessage());
			} catch (Exception e) {
				if (isDev) {
					e.printStackTrace();
				}
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			    		.body("Unexpected Error Occurred: " + e.getMessage());
			}
		}
	}

}
