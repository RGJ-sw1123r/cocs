package com.korbiztech.product.cocs.AS.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.AS.vo.paramVO;

@Mapper
public interface ASB060_DAO {
    public List<HashMap<String, ?>> selectList(paramVO map);
    public List<HashMap<String, ?>> constDivision();
    public List<HashMap<String, ?>> constName();
}
