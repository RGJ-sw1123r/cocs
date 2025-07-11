package com.korbiztech.product.cocs.CM.OR.service;

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

import com.korbiztech.product.cocs.CM.OR.vo.ORA030_VO;
import com.korbiztech.product.cocs.CM.OR.vo.paramVO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;
import com.korbiztech.product.cocs.SY.vo.SAA060_VO;

import jakarta.servlet.http.HttpServletRequest;

import com.korbiztech.product.cocs.CM.OR.dao.ORA030_DAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ORA030_Service {

    @Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
    private JsonUtil jsonUtil;
    
    @Autowired
	ORA030_DAO ora030DAO;


    public List<HashMap<String, ?>> selectList(paramVO searchCondition){

        return ora030DAO.selectList(searchCondition);
    }

    public List<HashMap<String, ?>> bankList(){

        return ora030DAO.bankList();
    }

    public List<HashMap<String, ?>> commList(paramVO searchCondition){

        return ora030DAO.commList(searchCondition);
    }

    public List<HashMap<String, ?>> gongList(paramVO searchCondition){

        return ora030DAO.gongList(searchCondition);
    }

    public List<HashMap<String, ?>> tab02Info(paramVO searchCondition){

        return ora030DAO.tab02Info(searchCondition);
    }

        public List<HashMap<String, ?>> postList(){

        return ora030DAO.postList();
    }


    public List<HashMap<String, ?>> tab03Info(paramVO searchCondition){

        return ora030DAO.tab03Info(searchCondition);
    }

    public List<HashMap<String, ?>> tab04Info(paramVO searchCondition){

        return ora030DAO.tab04Info(searchCondition);
    }

    public List<HashMap<String, ?>> tab05Info(paramVO searchCondition){

        return ora030DAO.tab05Info(searchCondition);
    }

    public List<HashMap<String, ?>> tab06Info(paramVO searchCondition){

        return ora030DAO.tab06Info(searchCondition);
    }

    public List<HashMap<String, ?>> tab07Info(paramVO searchCondition){

        return ora030DAO.tab07Info(searchCondition);
    }

    public ResponseEntity<?> saveGridData(HttpServletRequest request, String tabName) {
		String jsonString = jsonUtil.readJsonStringFromRequest(request);
		ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);
		if (errorResponse != null) {
			return errorResponse;
		} else {
			List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
			List<ORA030_VO> updateList = new ArrayList<>();
			List<ORA030_VO> insertList = new ArrayList<>();
			List<ORA030_VO> deleteList = new ArrayList<>();
			for (SaveGridDataVO item : voList) {
				Object data = item.getData();
				Gson gson = new Gson();
				String jsonData = gson.toJson(data);
				ORA030_VO vo = gson.fromJson(jsonData, ORA030_VO.class);
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
							ora030DAO.saveTab01UpdateData(updateList);
			            }
                        if (updateList.size() > 0) {
							ora030DAO.saveTab01_AttachUpdateData(updateList);
			            }
			            if (insertList.size() > 0 && ora030DAO.saveTab01InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
                        if (insertList.size() > 0 && ora030DAO.saveTab01_AttachInsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
			            if (deleteList.size() > 0 && ora030DAO.saveTab01DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_02" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab02UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab02InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab02DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_03" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab03UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab03InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab03DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_04" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab04UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab04InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab04DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_05" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab05UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab05InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab05DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_06" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab06UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab06InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab06DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
					}
					case "tab_07" -> {
						if (updateList.size() > 0) {
							ora030DAO.saveTab07UpdateData(updateList);
			            }
						if (insertList.size() > 0 && ora030DAO.saveTab07InsertData(insertList) != insertList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
			            }
						if (deleteList.size() > 0 && ora030DAO.saveTab07DeleteData(deleteList) != deleteList.size()) {
			                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
			            }
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
