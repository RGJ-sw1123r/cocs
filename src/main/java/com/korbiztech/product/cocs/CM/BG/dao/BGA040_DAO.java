package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.CM.BG.vo.BGA040_VO;

@Mapper
public interface BGA040_DAO {
    
    List<HashMap<String, ?>> selectGrid();

    int saveGrid(@Param("updateList") List<BGA040_VO> updateList);
}
