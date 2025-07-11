package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BGB010_DAO {
    
    List<HashMap<String, ?>> selectSite();
}
