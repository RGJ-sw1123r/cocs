package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORG050_VO;

@Mapper
public interface ORG050_DAO {
    
    List<HashMap<String, ?>> selectGrid(ORG050_VO params);
}
