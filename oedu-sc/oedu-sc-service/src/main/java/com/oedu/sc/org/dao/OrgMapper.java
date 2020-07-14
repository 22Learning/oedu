package com.oedu.sc.org.dao;

import com.oedu.sc.org.po.Org;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgMapper {
    int deleteByPrimaryKey(Long oeduOrgId);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(Long oeduOrgId);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}