package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGA060_VO;

@Mapper
public interface BGA060_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectChsu(BGA060_VO params);

    List<HashMap<String, ?>> selectGubu();

    List<HashMap<String, ?>> selectGrid(BGA060_VO params);
}
