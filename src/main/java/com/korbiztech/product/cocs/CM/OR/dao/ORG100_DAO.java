package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORG100_VO;

@Mapper
public interface ORG100_DAO {
    
    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectYear();

    List<HashMap<String, ?>> selectGrid(ORG100_VO params);

}
