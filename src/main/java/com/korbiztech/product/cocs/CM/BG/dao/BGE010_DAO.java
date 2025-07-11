package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGE010_VO;

@Mapper
public interface BGE010_DAO {
    
    List<HashMap<String, ?>> selectGubuGridData();

    List<HashMap<String, ?>> selectLgojGridData(BGE010_VO params);
    
    List<HashMap<String, ?>> selectMgojGridData(BGE010_VO params);
}
