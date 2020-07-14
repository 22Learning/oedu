package com.oedu.sc.role.dao;

import com.oedu.sc.role.dto.UserRoleDto;
import com.oedu.sc.role.po.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Long oeduUserRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long oeduUserRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRoleDto> getEffectiveList();
}