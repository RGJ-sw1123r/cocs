package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORG020_VO;

@Mapper
public interface ORG020_DAO {
    
    List<HashMap<String, ?>> selectGrid(ORG020_VO params);

    List<HashMap<String, ?>> selectGogu();
}
