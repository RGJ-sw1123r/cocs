package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.korbiztech.product.cocs.FA.AA.vo.AAXA080SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Mapper
public interface AAXA040SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);    
}
