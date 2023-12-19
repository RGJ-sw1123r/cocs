package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.korbiztech.product.cocs.FA.AA.vo.AAXA080SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@Mapper
public interface AAXA080SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);
    public List<HashMap<String, ?>> selectedSAUPJ_NM(paramVO searchCondition);

    int saveGrid01UpdateData(@Param("updateList") List<AAXA080SI_VO> updateList);
    int saveGrid01AttachUpdateData(@Param("updateList") List<AAXA080SI_VO> updateList);
    int saveGrid01DeleteData(@Param("deleteList") List<AAXA080SI_VO> deleteList);
    int saveGrid01AttachDeleteData(@Param("deleteList") List<AAXA080SI_VO> deleteList);
}
