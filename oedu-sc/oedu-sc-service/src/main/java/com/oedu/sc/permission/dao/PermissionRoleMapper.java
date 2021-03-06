package com.oedu.sc.permission.dao;

import com.oedu.sc.permission.po.PermissionRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRoleMapper {
    int deleteByPrimaryKey(Long oeduPermissionRoleId);

    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Long oeduPermissionRoleId);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);

    int insertBatch(List<PermissionRole> permissionRoles);
}