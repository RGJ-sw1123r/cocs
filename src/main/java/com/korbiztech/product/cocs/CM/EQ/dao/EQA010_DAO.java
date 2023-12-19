package com.korbiztech.product.cocs.CM.EQ.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.EQ.vo.EQA010_VO;

@Mapper
public interface EQA010_DAO {

    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectParentGrid(EQA010_VO params);
}
