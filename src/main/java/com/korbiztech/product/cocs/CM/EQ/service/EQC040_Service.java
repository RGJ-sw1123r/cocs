package com.korbiztech.product.cocs.CM.EQ.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.EQ.dao.EQC040_DAO;
import com.korbiztech.product.cocs.CM.EQ.vo.EQC040_VO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class EQC040_Service {

    @Autowired
    private EQC040_DAO eqcDAO;

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private ProfileChecker profileChecker;

    public List<HashMap<String, ?>> selectGrid(EQC040_VO params) {
        return eqcDAO.selectGrid(params);
    };

    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<?> saveGridData(HttpServletRequest request) {
        String jsonString = jsonUtil.readJsonStringFromRequest(request);
        // System.out.println(jsonString);
        ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);

        if (errorResponse != null) {
            System.out.println(errorResponse);
            return errorResponse;
        } else {
            List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
            List<EQC040_VO> updateList = new ArrayList<>();
            List<EQC040_VO> insertList = new ArrayList<>();
            List<EQC040_VO> deleteList = new ArrayList<>();
            
            for (SaveGridDataVO item : voList) {
                Object data = item.getData();
                EQC040_VO vo = JsonUtil.convertAndSanitize(data, EQC040_VO.class);
                switch (item.getStatus()) {
                    case "u" -> updateList.add(vo);
                    case "i" -> insertList.add(vo);
                    case "d" -> deleteList.add(vo);
                }
            }

            boolean isDev = profileChecker.isDevProfileActive();
            try {
                if (updateList.size() > 0) {
                    eqcDAO.saveGrid(updateList);
                }
                if (insertList.size() > 0 && eqcDAO.insertGrid(insertList) != insertList.size()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
                }
                if (deleteList.size() > 0 && eqcDAO.deleteGrid(deleteList) != deleteList.size()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Failure");
                }
                
                HashMap<String, Object> response = new HashMap<>();
                response.put("message", "Ajax saveGridData success");
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
}
