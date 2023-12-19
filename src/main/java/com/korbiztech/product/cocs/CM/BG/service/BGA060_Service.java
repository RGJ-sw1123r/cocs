package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGA060_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA060_VO;

@Service
public class BGA060_Service {

    @Autowired
    BGA060_DAO bgaDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgaDAO.selectSite();
    }
    
    public List<HashMap<String, ?>> selectChsu(BGA060_VO params) {
        return bgaDAO.selectChsu(params);
    }

    public List<HashMap<String, ?>> selectGubu() {
        return bgaDAO.selectGubu();
    }

    public List<HashMap<String, ?>> selectGrid(BGA060_VO parmas) {
        return bgaDAO.selectGrid(parmas);
    }
}