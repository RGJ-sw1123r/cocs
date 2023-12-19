package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGB010_DAO;

@Service
public class BGB010_Service {
    
    @Autowired
    private BGB010_DAO bgbDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgbDAO.selectSite();
    }
}
