package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGD010_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGD010_VO;

@Service("BGD010_Service")
public class BGD010_Service {

    @Autowired
    private BGD010_DAO bgdDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgdDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectDate() {
        return bgdDAO.selectDate();
    }

    public List<HashMap<String, ?>> selectParentGrid(BGD010_VO params) {
        return bgdDAO.selectParentGrid(params);
    }

    public List<HashMap<String, ?>> selectChildGrid(BGD010_VO params) {
        return bgdDAO.selectChildGrid(params);
    }

    public List<HashMap<String, ?>> selectTree(BGD010_VO params) {
        return bgdDAO.selectTree(params);
    }
}
