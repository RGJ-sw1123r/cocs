package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORA020_VO;

@Mapper
public interface ORA020_DAO {
    
    List<HashMap<String, ?>> selectTree();
    
    List<HashMap<String, ?>> selectGrid(ORA020_VO params);
}
