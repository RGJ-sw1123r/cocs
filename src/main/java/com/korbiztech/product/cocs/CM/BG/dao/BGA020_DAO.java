package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGA020_VO;

@Mapper
public interface BGA020_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectGubu();

    List<HashMap<String, ?>> selectChsu(BGA020_VO params);
    
    List<HashMap<String, ?>> selectGrid(BGA020_VO params);
}
