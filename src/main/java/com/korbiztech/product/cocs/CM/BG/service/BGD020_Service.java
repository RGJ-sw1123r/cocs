package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGD020_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGD020_VO;

@Service
public class BGD020_Service {
    
    @Autowired
    private BGD020_DAO bgdDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgdDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectDate() {
        return bgdDAO.selectDate();
    }

    public List<HashMap<String, ?>> selectGrid(BGD020_VO params) {
        return bgdDAO.selectGrid(params);
    }
}