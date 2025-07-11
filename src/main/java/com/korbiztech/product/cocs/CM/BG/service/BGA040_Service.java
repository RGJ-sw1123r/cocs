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

import com.korbiztech.product.cocs.CM.BG.dao.BGA040_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA040_VO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BGA040_Service {
    
    @Autowired
    private BGA040_DAO bgaDAO;

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private ProfileChecker profileChecker;

    public List<HashMap<String, ?>> selectGrid() {
        return bgaDAO.selectGrid();
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
            List<BGA040_VO> updateList = new ArrayList<>();

            for (SaveGridDataVO item : voList) {
                Object data = item.getData();
                BGA040_VO vo = JsonUtil.convertAndSanitize(data, BGA040_VO.class);
                switch (item.getStatus()) {
                    case "u" -> updateList.add(vo);
                }
            }
            boolean isDev = profileChecker.isDevProfileActive();
            try {
                if (updateList.size() > 0) {
                    bgaDAO.saveGrid(updateList);
                }
                HashMap<String, Object> response = new HashMap<>();
                response.put("message", "Ajax saveGridData success");
                response.put("updatedCount", updateList.size());
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
