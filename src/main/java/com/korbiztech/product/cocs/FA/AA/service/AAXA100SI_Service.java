package com.korbiztech.product.cocs.FA.AA.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;
import com.korbiztech.product.cocs.FA.AA.dao.AAXA100SI_DAO;
import com.korbiztech.product.cocs.FA.AA.vo.AAXA100SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
@Transactional
public class AAXA100SI_Service {
	
    @Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
    private JsonUtil jsonUtil;

    @Autowired
	AAXA100SI_DAO dao;

    public List<HashMap<String, ?>> selectList(paramVO searchCondition){

        return dao.selectList(searchCondition);
    }

    public List<HashMap<String, ?>> selectDetailList(paramVO searchCondition){

        return dao.selectDetailList(searchCondition);
    }

    public ResponseEntity<?> saveGridData(HttpServletRequest request, String gridName) {
		String jsonString = jsonUtil.readJsonStringFromRequest(request);
		ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);
		if (errorResponse != null) {
			return errorResponse;
		} else {
			List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
			List<AAXA100SI_VO> updateList = new ArrayList<>();
			List<AAXA100SI_VO> insertList = new ArrayList<>();
			List<AAXA100SI_VO> deleteList = new ArrayList<>();
			for (SaveGridDataVO item : voList) {
				Object data = item.getData();
				Gson gson = new Gson();
				String jsonData = gson.toJson(data);
				AAXA100SI_VO vo = gson.fromJson(jsonData, AAXA100SI_VO.class);
				switch (item.getStatus()) {
					case "u" -> updateList.add(vo);
					case "i" -> insertList.add(vo);
					case "d" -> deleteList.add(vo);
				}
			}

			boolean isDev = profileChecker.isDevProfileActive();
			try {
				switch (gridName) {
					case "viewX.grid_01" -> {
						if (updateList.size() > 0) {
							dao.saveGrid01UpdateData(updateList);
			            }
			            if (insertList.size() > 0 && dao.saveGrid01InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
			            if (deleteList.size() > 0 && dao.saveGrid01DeleteData(deleteList) < deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "viewX.grid_02" -> {
						if (updateList.size() > 0) {
							dao.saveGrid01UpdateData(updateList);
			            }
						if (insertList.size() > 0 && dao.saveGrid01InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && dao.saveGrid02DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					default -> throw new IllegalArgumentException("Invalid tab name: " + gridName);
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
