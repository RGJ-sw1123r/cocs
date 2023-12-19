package com.korbiztech.product.cocs.SY.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.SY.vo.SAA060_VO;

@Mapper
public interface SAA060_DAO {

	List<HashMap<String, ?>> getCategoryGridData();
	List<HashMap<String, ?>> getMajorCategoryGridData();
	List<HashMap<String, ?>> getSubCategoryGridData();
	int saveCategoryUpdateData(@Param("updateList") List<SAA060_VO> updateList);
	int saveCategoryInsertData(@Param("insertList") List<SAA060_VO> insertList);
	int saveCategoryDeleteData(@Param("deleteList") List<SAA060_VO> deleteList);
	
}
