package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGE030_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGE030_VO;

@Service
public class BGE030_Service {

    @Autowired
    private BGE030_DAO bgeDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgeDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectGrid(BGE030_VO params) {
        return bgeDAO.selectGrid(params);
    }
}