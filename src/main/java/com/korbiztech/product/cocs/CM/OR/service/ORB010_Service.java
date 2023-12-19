package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORB010_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORB010_VO;

@Service
public class ORB010_Service {
    
    @Autowired
    private ORB010_DAO oraDAO;

    public List<HashMap<String, ?>> selectSite() {
        return oraDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectMainGrid(ORB010_VO params) {
        return oraDAO.selectMainGrid(params);
    }

    public List<HashMap<String, ?>> selectSubGrid(ORB010_VO params) {
        return oraDAO.selectSubGrid(params);
    }
}
