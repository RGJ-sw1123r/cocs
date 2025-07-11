package com.korbiztech.product.cocs.CM.EQ.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.EQ.vo.EQA020_VO;

@Mapper
public interface EQA020_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectGrid(EQA020_VO params);
}