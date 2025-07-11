package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG060_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORG060_VO;

@Service
public class ORG060_Service {
    
    @Autowired
    private ORG060_DAO orgDAO;

    public List<HashMap<String, ?>> selectSubGrop(ORG060_VO params) {
        return orgDAO.selectSubGrop(params);
    }

    public List<HashMap<String, ?>> selectGrid(ORG060_VO params) {
        return orgDAO.selectGrid(params);
    }
}
