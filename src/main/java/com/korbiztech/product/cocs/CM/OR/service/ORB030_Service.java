package com.korbiztech.product.cocs.CM.OR.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korbiztech.product.cocs.CM.OR.vo.ORB030_VO;
import com.korbiztech.product.cocs.CM.OR.vo.paramVO;
import com.korbiztech.product.cocs.COM.util.JsonUtil;
import com.korbiztech.product.cocs.COM.util.ProfileChecker;
import com.korbiztech.product.cocs.COM.vo.SaveGridDataVO;


import jakarta.servlet.http.HttpServletRequest;
import com.korbiztech.product.cocs.CM.OR.dao.ORB030_DAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ORB030_Service {

    @Autowired
    private ProfileChecker profileChecker;
	
	@Autowired
    private JsonUtil jsonUtil;
    
    @Autowired
	ORB030_DAO dao;
    
}
