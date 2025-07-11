package com.korbiztech.product.cocs.CM.EQ.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.CM.EQ.vo.EQC040_VO;

@Mapper
public interface EQC040_DAO {

    List<HashMap<String, ?>> selectGrid(EQC040_VO params);

    int saveGrid(@Param("updateList") List<EQC040_VO> updateList);

    int insertGrid(@Param("updateList") List<EQC040_VO> insertList);

    int deleteGrid(@Param("updateList") List<EQC040_VO> deleteList);
}