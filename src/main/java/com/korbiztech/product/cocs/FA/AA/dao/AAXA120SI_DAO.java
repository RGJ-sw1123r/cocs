package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.FA.AA.vo.AAXA120SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Mapper
public interface AAXA120SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);
    public List<HashMap<String, ?>> cardList();
    public List<HashMap<String, ?>> ownerList();
    public List<HashMap<String, ?>> deptList();
    public List<HashMap<String, ?>> custList();
    public List<HashMap<String, ?>> howtopayList();

    int saveGrid01UpdateData(@Param("updateList") List<AAXA120SI_VO> updateList);
    int saveGrid01InsertData(@Param("insertList") List<AAXA120SI_VO> insertList);
    int saveGrid01DeleteData(@Param("deleteList") List<AAXA120SI_VO> deleteList);
}
