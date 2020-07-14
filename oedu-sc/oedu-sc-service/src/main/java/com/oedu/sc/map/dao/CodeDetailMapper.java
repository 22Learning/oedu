package com.oedu.sc.map.dao;

import com.oedu.sc.map.po.CodeDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeDetailMapper {
    int deleteByPrimaryKey(Long oeduCodeDetailId);

    int insert(CodeDetail record);

    int insertSelective(CodeDetail record);

    CodeDetail selectByPrimaryKey(Long oeduCodeDetailId);

    int updateByPrimaryKeySelective(CodeDetail record);

    int updateByPrimaryKey(CodeDetail record);

    List<CodeDetail> selectCodeDetailByType(String codeType);

    List<CodeDetail> selectCodeDetailByTypeList(@Param("list") List<String> codeTypes);
}