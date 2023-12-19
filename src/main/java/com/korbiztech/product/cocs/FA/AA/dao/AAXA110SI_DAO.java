package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.FA.AA.vo.AAXA110SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Mapper
public interface AAXA110SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);
    public List<HashMap<String, ?>> custList();
    public List<HashMap<String, ?>> taxList();
    public List<HashMap<String, ?>> modal_01Info(paramVO searchCondition);

    int saveGrid01UpdateData(@Param("updateList") List<AAXA110SI_VO> updateList);
    int saveGrid01InsertData(@Param("insertList") List<AAXA110SI_VO> insertList);
    int saveGrid01DeleteData(@Param("deleteList") List<AAXA110SI_VO> deleteList);
    int saveGrid01AttachUpdateData(@Param("updateList") List<AAXA110SI_VO> updateList);
    int saveGrid01AttachInsertData(@Param("insertList") List<AAXA110SI_VO> insertList);  
}
