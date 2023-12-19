package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGE030_VO;

@Mapper
public interface BGE030_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectGrid(BGE030_VO params);
}