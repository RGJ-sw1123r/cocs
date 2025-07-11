package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.BG.dao.BGE010_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGE010_VO;

@Service("BGE010_Service")
public class BGE010_Service {
    
    @Autowired
    private BGE010_DAO bgeDAO;

    @Transactional(readOnly = true)
    public List<HashMap<String, ?>> getGridData(String tabName, BGE010_VO params) {
        return switch (tabName) {
            case "tab_01" -> bgeDAO.selectGubuGridData();
            case "tab_02" -> bgeDAO.selectLgojGridData(params);
            case "tab_03" -> bgeDAO.selectMgojGridData(params);
            default -> throw new IllegalArgumentException("Unexpected value: " + tabName);
        };
    }
    
}
