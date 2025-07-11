package com.korbiztech.product.cocs.CM.BG.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.BG.dao.BGA010_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA010_VO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BGA010_Service {
    
    @Autowired
    private BGA010_DAO bgaDAO;

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private ProfileChecker profileChecker;

    public List<HashMap<String, ?>> selectParentGrid(BGA010_VO params) {
        return bgaDAO.selectParentGrid(params);
    }

    public List<HashMap<String, ?>> selectChildGrid(BGA010_VO params) {
        return bgaDAO.selectChildGrid(params);
    }

    @SuppressWarnings("rawtypes")
    @Transactional
    public ResponseEntity<?> saveGridData(HttpServletRequest request) {
        String jsonString = jsonUtil.readJsonStringFromRequest(request);
        ResponseEntity<?> errorResponse = jsonUtil.validateJsonString(jsonString);
        if (errorResponse != null) {
            System.out.println(errorResponse);
            return errorResponse;
        } else {
            List<SaveGridDataVO> voList = JsonUtil.parseJsonToList(jsonString, SaveGridDataVO.class);
            List<BGA010_VO> updateList = new ArrayList<>();
            List<BGA010_VO> insertList = new ArrayList<>();
            List<BGA010_VO> deleteList = new ArrayList<>();

            for (SaveGridDataVO item : voList) {
                Object data = item.getData();
                BGA010_VO vo = JsonUtil.convertAndSanitize(data, BGA010_VO.class);
                switch (item.getStatus()) {
                    case "u" -> updateList.add(vo);
                    case "i" -> insertList.add(vo);
                    case "d" -> deleteList.add(vo);
                }
            }
            boolean isDev = profileChecker.isDevProfileActive();
            try {
                if (updateList.size() > 0) {
                    bgaDAO.saveChildGrid(updateList);
                }
                if (insertList.size() > 0 && bgaDAO.insertChildGrid(insertList) != insertList.size()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert Failure");
                }
                if (deleteList.size() > 0 && bgaDAO.deleteChildGrid(deleteList) != deleteList.size()) {
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