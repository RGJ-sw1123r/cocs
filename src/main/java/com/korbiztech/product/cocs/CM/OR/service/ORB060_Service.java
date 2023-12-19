package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORB060_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORB060_VO;

@Service
public class ORB060_Service {
    
    @Autowired
    private ORB060_DAO oraDAO;

    public List<HashMap<String, ?>> selectSite() {
        return oraDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectGrid(ORB060_VO params) {
        return oraDAO.selectGrid(params);
    }
}
