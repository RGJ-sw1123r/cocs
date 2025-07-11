package com.korbiztech.product.cocs.AS.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.AS.dao.ASB060_DAO;
import com.korbiztech.product.cocs.AS.vo.paramVO;

@Service
@Transactional
public class ASB060_Service {
	
    @Autowired
	ASB060_DAO asDAO;

    HashMap<String, String> map;

	public List<HashMap<String, ?>> selectList(paramVO searchCondition){

    	return asDAO.selectList(searchCondition);
	}

	public List<HashMap<String, ?>> constDivision(){

    	return asDAO.constDivision();
	}

	public List<HashMap<String, ?>> constName(){

		return asDAO.constName();
	}
}
