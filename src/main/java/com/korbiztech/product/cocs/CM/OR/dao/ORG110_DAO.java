package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORG110_VO;

@Mapper
public interface ORG110_DAO {
    
    List<HashMap<String, ?>> selectGubuGridData();

    List<HashMap<String, ?>> selectLgojGridData(ORG110_VO params);
    
    List<HashMap<String, ?>> selectMgojGridData(ORG110_VO params);
}
