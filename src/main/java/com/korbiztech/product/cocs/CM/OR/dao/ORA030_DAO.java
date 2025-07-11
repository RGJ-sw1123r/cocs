package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korbiztech.product.cocs.CM.OR.vo.ORA030_VO;
import com.korbiztech.product.cocs.CM.OR.vo.paramVO;

@Mapper
public interface ORA030_DAO {
    public List<HashMap<String, ?>> selectList(paramVO searchCondition);

    public List<HashMap<String, ?>> bankList();

    public List<HashMap<String, ?>> commList(paramVO searchCondition);

    public List<HashMap<String, ?>> gongList(paramVO searchCondition);

    public List<HashMap<String, ?>> tab02Info(paramVO searchCondition);

    public List<HashMap<String, ?>> postList();

    public List<HashMap<String, ?>> tab03Info(paramVO searchCondition);

    public List<HashMap<String, ?>> tab04Info(paramVO searchCondition);

    public List<HashMap<String, ?>> tab05Info(paramVO searchCondition);

    public List<HashMap<String, ?>> tab06Info(paramVO searchCondition);

    public List<HashMap<String, ?>> tab07Info(paramVO searchCondition);

    int saveTab01UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab01_AttachUpdateData(@Param("updateList") List<ORA030_VO> updateList);
	int saveTab01InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab01_AttachInsertData(@Param("insertList") List<ORA030_VO> insertList);
	int saveTab01DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab02UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab02InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab02DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab03UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab03InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab03DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab04UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab04InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab04DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab05UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab05InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab05DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab06UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab06InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab06DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);

    int saveTab07UpdateData(@Param("updateList") List<ORA030_VO> updateList);
    int saveTab07InsertData(@Param("insertList") List<ORA030_VO> insertList);
    int saveTab07DeleteData(@Param("deleteList") List<ORA030_VO> deleteList);
}
