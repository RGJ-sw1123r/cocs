package com.korbiztech.product.cocs.CM.EQ.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.EQ.dao.EQA020_DAO;
import com.korbiztech.product.cocs.CM.EQ.vo.EQA020_VO;

@Service
public class EQA020_Service {

    @Autowired
    EQA020_DAO eqaDAO;

    public List<HashMap<String, ?>> selectSite() {
        return eqaDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectGrid(EQA020_VO params) {
        return eqaDAO.selectGrid(params);
    }
}
