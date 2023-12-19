package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGC010_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGC010_VO;

@Service
public class BGC010_Service {

    @Autowired
    BGC010_DAO bgcDAO;

    public List<HashMap<String, ?>> selectSite() {
        return bgcDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectChsu(BGC010_VO params) {
        return bgcDAO.selectChsu(params);
    }
    
}
