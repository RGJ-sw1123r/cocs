package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGA020_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA020_VO;

@Service
public class BGA020_Service {
    
    @Autowired
    BGA020_DAO bgaDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgaDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectGubu() {
        return bgaDAO.selectGubu();
    }

    public List<HashMap<String, ?>> selectChsu(BGA020_VO params) {
        return bgaDAO.selectChsu(params);
    }

    public List<HashMap<String, ?>> selectGrid(BGA020_VO params) {
        return bgaDAO.selectGrid(params);
    }
}
