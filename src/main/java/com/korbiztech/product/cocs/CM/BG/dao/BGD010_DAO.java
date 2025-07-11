package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGD010_VO;

@Mapper
public interface BGD010_DAO {
    
    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectDate();

    List<HashMap<String, ?>> selectParentGrid(BGD010_VO params);

    List<HashMap<String, ?>> selectChildGrid(BGD010_VO params);

    List<HashMap<String, ?>> selectTree(BGD010_VO params);
}