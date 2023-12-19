package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG010_DAO;


@Service
public class ORG010_Service {
    
    @Autowired
    private ORG010_DAO orgDAO;

    public List<HashMap<String, ?>> selectGrid() {
        return orgDAO.selectGrid();
    }
}
