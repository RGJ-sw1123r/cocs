package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORB060_VO;

@Mapper
public interface ORB060_DAO {
    
    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectGrid(ORB060_VO params);
}
