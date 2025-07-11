package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG100_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORG100_VO;


@Service
public class ORG100_Service {
    
    @Autowired
    private ORG100_DAO orgDAO;

    public List<HashMap<String, ?>> selectSite() {
        return orgDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectYear() {
        return orgDAO.selectYear();
    }

    public List<HashMap<String, ?>> selectGrid(ORG100_VO params) {
        return orgDAO.selectGrid(params);
    }
}
