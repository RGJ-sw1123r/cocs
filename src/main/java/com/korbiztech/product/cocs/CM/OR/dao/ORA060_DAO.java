package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORA060_VO;

@Mapper
public interface ORA060_DAO {
    
    List<HashMap<String, ?>> selectGubu();

    List<HashMap<String, ?>> selectParentGrid(ORA060_VO params);

    List<HashMap<String, ?>> selectChildGrid_TP(ORA060_VO params);
}
