package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGA050_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGA050_VO;

@Service
public class BGA050_Service {
    
    @Autowired
    BGA050_DAO bgaDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgaDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectChsu(BGA050_VO params) {
        return bgaDAO.selectChsu(params);
    }

    public List<HashMap<String, ?>> selectGrid(BGA050_VO params) {
        return bgaDAO.selectGrid(params);
    }

    public List<HashMap<String, ?>> selectAmt(BGA050_VO params) {
        return bgaDAO.selectAmt(params);
    }
}
