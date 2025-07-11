package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ORA050_DAO {
    
    public List<HashMap<String, Object>> selectTree();
}
