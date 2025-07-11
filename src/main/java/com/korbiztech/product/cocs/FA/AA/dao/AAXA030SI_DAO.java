package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.FA.AA.vo.AAXA030SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.AAXA080SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.AAXA100SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Mapper
public interface AAXA030SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);
    public List<HashMap<String, ?>> deptList(paramVO searchCondition);
    public List<HashMap<String, ?>> empList(paramVO searchCondition);
    public List<HashMap<String, ?>> costList(paramVO searchCondition);
    public List<HashMap<String, ?>> gongList(paramVO searchCondition);
    public List<HashMap<String, ?>> govList(paramVO searchCondition);
    public List<HashMap<String, ?>> gongsaList(paramVO searchCondition);
    public List<HashMap<String, ?>> bonsaList(paramVO searchCondition);
    public List<HashMap<String, ?>> taxpayList(paramVO searchCondition);
    public List<HashMap<String, ?>> siteList(paramVO searchCondition);
    public List<HashMap<String, ?>> subcontList(paramVO searchCondition);

    int saveGrid01UpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid01AttachUpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid01Attach_02UpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid01Attach_03UpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid01InsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid01AttachInsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid01Attach_02InsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid01Attach_03InsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid01DeleteData(@Param("deleteList") List<AAXA030SI_VO> deleteList);
    int saveGrid01AttachDeleteData(@Param("deleteList") List<AAXA030SI_VO> deleteList);

    int saveGrid04UpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid04InsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid04DeleteData(@Param("deleteList") List<AAXA030SI_VO> deleteList);

    int saveGrid05UpdateData(@Param("updateList") List<AAXA030SI_VO> updateList);
    int saveGrid05InsertData(@Param("insertList") List<AAXA030SI_VO> insertList);
    int saveGrid05DeleteData(@Param("deleteList") List<AAXA030SI_VO> deleteList);
    
}
