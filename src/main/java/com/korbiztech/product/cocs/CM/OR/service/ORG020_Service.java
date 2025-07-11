package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORG020_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORG020_VO;

@Service
public class ORG020_Service {
    
    @Autowired
    private ORG020_DAO orgDAO;

    public List<HashMap<String, ?>> selectGrid(ORG020_VO params) {
        return orgDAO.selectGrid(params);
    }

    public List<HashMap<String, ?>> selectGogu() {
        return orgDAO.selectGogu();
    }
}
