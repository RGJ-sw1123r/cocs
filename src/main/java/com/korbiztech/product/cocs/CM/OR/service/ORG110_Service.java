package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.OR.dao.ORG110_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORG110_VO;

@Service("ORG110_Service")
public class ORG110_Service {
    
    @Autowired
    private ORG110_DAO orgDAO;

    @Transactional(readOnly = true)
    public List<HashMap<String, ?>> getGridData(String tabName, ORG110_VO params) {
        return switch (tabName) {
            case "tab_01" -> orgDAO.selectGubuGridData();
            case "tab_02" -> orgDAO.selectLgojGridData(params);
            case "tab_03" -> orgDAO.selectMgojGridData(params);
            default -> throw new IllegalArgumentException("Unexpected value: " + tabName);
        };
    }
}
