package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.CM.BG.vo.BGA010_VO;

@Mapper
public interface BGA010_DAO {

    List<HashMap<String, ?>> selectParentGrid(BGA010_VO params);

    List<HashMap<String, ?>> selectChildGrid(BGA010_VO params);

    int saveChildGrid(@Param("updateList") List<BGA010_VO> updateList);

    int insertChildGrid(@Param("insertList") List<BGA010_VO> insertList);

    int deleteChildGrid(@Param("deleteList") List<BGA010_VO> deleteList);
}
