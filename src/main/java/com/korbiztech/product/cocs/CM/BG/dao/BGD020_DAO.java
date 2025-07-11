package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGD020_VO;

@Mapper
public interface BGD020_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectDate();
        
    List<HashMap<String, ?>> selectGrid(BGD020_VO params);
}
