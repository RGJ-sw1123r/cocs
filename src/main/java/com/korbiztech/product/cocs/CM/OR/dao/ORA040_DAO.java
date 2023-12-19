package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORA040_VO;

@Mapper
public interface ORA040_DAO {
    
    List<HashMap<String, ?>> selectTree();
    
    List<HashMap<String, ?>> selectGrid(ORA040_VO params);
}
