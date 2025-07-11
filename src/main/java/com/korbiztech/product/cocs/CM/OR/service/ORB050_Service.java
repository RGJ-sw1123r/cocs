package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.OR.dao.ORB050_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORB050_VO;

@Service
public class ORB050_Service {
    
    @Autowired
    private ORB050_DAO oraDAO;

    public List<HashMap<String, ?>> selectSite() {
        return oraDAO.selectSite();
    }
    
    @Transactional(readOnly = true)
    public List<HashMap<String, ?>> getGridData(String tabName, ORB050_VO params) {
        return switch (tabName) {
            case "tab_01" -> oraDAO.selectTab01Grid(params);
            case "tab_02" -> oraDAO.selectTab02Grid(params);
            case "tab_03" -> oraDAO.selectTab03Grid(params);
            default -> throw new IllegalArgumentException("Unexpected value: " + tabName);
        };
    }
}
