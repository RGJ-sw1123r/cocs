package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORA060_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORA060_VO;

@Service
public class ORA060_Service {
    
    @Autowired
    private ORA060_DAO oraDAO;

    public List<HashMap<String, ?>> selectGubu() {
        return oraDAO.selectGubu();
    }

    public List<HashMap<String, ?>> selectParentGrid(ORA060_VO params) {
        return oraDAO.selectParentGrid(params);
    }

    public List<HashMap<String, ?>> selectChildGrid_TP(ORA060_VO params) {
        return oraDAO.selectChildGrid_TP(params);
    }
}
