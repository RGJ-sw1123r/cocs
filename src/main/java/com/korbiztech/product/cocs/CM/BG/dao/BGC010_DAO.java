package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGC010_VO;

@Mapper
public interface BGC010_DAO {
 
    public List<HashMap<String, ?>> selectSite();

    public List<HashMap<String, ?>> selectChsu(BGC010_VO params);
}
