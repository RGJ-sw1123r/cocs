package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGA050_VO;

@Mapper
public interface BGA050_DAO {

    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectChsu(BGA050_VO params);
    
    List<HashMap<String, ?>> selectGrid(BGA050_VO params);

    List<HashMap<String, ?>> selectAmt(BGA050_VO params);
}
