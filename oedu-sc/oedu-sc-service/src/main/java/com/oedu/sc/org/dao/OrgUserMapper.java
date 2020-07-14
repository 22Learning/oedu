package com.oedu.sc.org.dao;

import com.oedu.sc.org.po.OrgUser;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUserMapper {
    int deleteByPrimaryKey(Long oeduOrgUserId);

    int insert(OrgUser record);

    int insertSelective(OrgUser record);

    OrgUser selectByPrimaryKey(Long oeduOrgUserId);

    int updateByPrimaryKeySelective(OrgUser record);

    int updateByPrimaryKey(OrgUser record);
}