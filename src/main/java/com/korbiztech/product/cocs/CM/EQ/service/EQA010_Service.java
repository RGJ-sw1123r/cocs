package com.korbiztech.product.cocs.CM.EQ.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.EQ.dao.EQA010_DAO;
import com.korbiztech.product.cocs.CM.EQ.vo.EQA010_VO;

@Service
public class EQA010_Service {

    @Autowired
    EQA010_DAO eqaDAO;

    public List<HashMap<String, ?>> selectSite() {
        return eqaDAO.selectSite();
    }

    public List<HashMap<String, ?>> selectParentGrid(EQA010_VO params) {
        return eqaDAO.selectParentGrid(params);
    }
}
