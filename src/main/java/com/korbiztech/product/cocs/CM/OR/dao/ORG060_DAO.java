package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORG060_VO;

@Mapper
public interface ORG060_DAO {
    
    List<HashMap<String, ?>> selectSubGrop(ORG060_VO params);

    List<HashMap<String, ?>> selectGrid(ORG060_VO params);
}
