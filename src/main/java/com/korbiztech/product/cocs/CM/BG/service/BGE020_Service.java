package com.korbiztech.product.cocs.CM.BG.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.BG.dao.BGE020_DAO;
import com.korbiztech.product.cocs.CM.BG.vo.BGE020_VO;

@Service
public class BGE020_Service {
    
    @Autowired
    private BGE020_DAO bgeDAO;

    public List<HashMap<String, ?>> selectGubu() {
        return bgeDAO.selectGubu();
    }

    public List<HashMap<String, ?>> selectResource(BGE020_VO params) {
        return bgeDAO.selectResource(params);
    }

    public List<HashMap<String, ?>> selectGrid(BGE020_VO params) {
        return bgeDAO.selectGrid(params);
    }
}
