package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG050_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORG050_VO;

@Service
public class ORG050_Service {
    
    @Autowired
    private ORG050_DAO orgDAO;

    public List<HashMap<String, ?>> selectGrid(ORG050_VO params) {
        return orgDAO.selectGrid(params);
    }
}
