package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORB010_VO;

@Mapper
public interface ORB010_DAO {
    
    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectMainGrid(ORB010_VO params);

    List<HashMap<String, ?>> selectSubGrid(ORB010_VO params);
}
