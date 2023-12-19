package com.korbiztech.product.cocs.FA.AA.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

 
import com.korbiztech.product.cocs.FA.AA.vo.AAXA020SI_VO;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;
 

@Mapper
public interface AAXA020SI_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);
//    public List<HashMap<String, ?>> selectDetailList(paramVO searchCondition);
    
    int saveGrid01UpdateData(@Param("updateList") List<AAXA020SI_VO> updateList);
    int saveGrid01InsertData(@Param("insertList") List<AAXA020SI_VO> insertList);
    int saveGrid01DeleteData(@Param("deleteList") List<AAXA020SI_VO> deleteList);
}
