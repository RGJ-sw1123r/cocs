package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORA010_DAO;

@Service
public class ORA010_Service {
    
    @Autowired
    private ORA010_DAO oraDAO;

    public List<HashMap<String, ?>> selectYear() {
        return oraDAO.selectYear();
    }
    
    public List<HashMap<String, ?>> selectGrid() {
        return oraDAO.selectGrid();
    }
}
