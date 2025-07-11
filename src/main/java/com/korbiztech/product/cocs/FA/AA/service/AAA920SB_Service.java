package com.korbiztech.product.cocs.FA.AA.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.FA.AA.dao.AAA920SB_DAO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Service
@Transactional
public class AAA920SB_Service {
	
    @Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
    private JsonUtil jsonUtil;

    @Autowired
	AAA920SB_DAO dao;    

    public List<HashMap<String, ?>> selectList(paramVO searchCondition){

        return dao.selectList(searchCondition);
    }
}
