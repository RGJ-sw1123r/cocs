package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG030_DAO;

@Service
public class ORG030_Service {
    
    @Autowired
    private ORG030_DAO orgDAO;

    public List<HashMap<String, ?>> selectGrid() {
        return orgDAO.selectGrid();
    }
}
