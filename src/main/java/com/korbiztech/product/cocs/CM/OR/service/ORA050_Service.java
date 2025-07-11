package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORA050_DAO;

@Service
public class ORA050_Service {
    
    @Autowired
    ORA050_DAO oraDAO;

    public List<HashMap<String, Object>> selectTree() {
        return oraDAO.selectTree();
    }

}
