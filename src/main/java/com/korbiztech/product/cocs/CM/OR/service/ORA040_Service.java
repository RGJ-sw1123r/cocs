package com.korbiztech.product.cocs.CM.OR.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.CM.OR.dao.ORA040_DAO;
import com.korbiztech.product.cocs.CM.OR.vo.ORA040_VO;

@Service
public class ORA040_Service {
    
    @Autowired
    private ORA040_DAO oraDAO;

    public List<HashMap<String, ?>> selectTree() {
        return oraDAO.selectTree();
    }
    
    public List<HashMap<String, ?>> selectGrid(ORA040_VO params) {
        return oraDAO.selectGrid(params);
    }
}
