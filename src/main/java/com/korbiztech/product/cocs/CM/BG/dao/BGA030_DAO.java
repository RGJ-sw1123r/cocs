package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.CM.BG.vo.BGA030_VO;
import com.korbiztech.product.cocs.CM.BG.vo.paramVO;
import com.korbiztech.product.cocs.COM.vo.FileParamsVO;

@Mapper
public interface BGA030_DAO {

    List<HashMap<String, ?>> selectSite();
    
    List<HashMap<String, ?>> selectChsu(paramVO params);
    
    List<HashMap<String, ?>> selectParentGrid(paramVO params);
    
    List<HashMap<String, ?>> selectChildGrid(paramVO params);
    
    List<HashMap<String, ?>> selectThreeTree(paramVO params);

    List<HashMap<String, ?>> selectFourTree(paramVO params);
    
    List<HashMap<String, ?>> selectGogu(paramVO params);

    List<HashMap<String, ?>> selectAddGJ(paramVO params);

    List<HashMap<String, ?>> selectAddItem(paramVO params);
    
    List<HashMap<String, ?>> selectGubu();

    List<HashMap<String, ?>> selectDivideItem(paramVO params);

    int saveCategoryUpdateData1(@Param("updateList") List<BGA030_VO> updateList);

    int saveCategoryUpdateData2(@Param("updateList") List<BGA030_VO> updateList);
    
    int saveDivideItems(@Param("updateList") List<BGA030_VO> updateList);

    void insertAddGJ(paramVO params);

    void insertDivideItems(paramVO params);

    int saveCategoryInsertData(@Param("insertList") List<BGA030_VO> insertList);

    int saveCategoryDeleteData(@Param("deleteList") List<BGA030_VO> deleteList);

    int addFiles(@Param("addFileParams") List<FileParamsVO> addFileParams);
    
    int deleteFiles(@Param("deleteFileParams") List<FileParamsVO> deleteFileParams);
}
