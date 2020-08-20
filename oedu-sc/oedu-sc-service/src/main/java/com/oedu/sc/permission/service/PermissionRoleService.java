package com.oedu.sc.permission.service;


import com.oedu.common.tools.StringUtils;
import com.oedu.sc.permission.dao.PermissionRoleMapper;
import com.oedu.sc.permission.dto.PermissionRoleReq;
import com.oedu.sc.permission.po.PermissionRole;
import com.oedu.sc.role.dto.RoleReq;
import com.oedu.sc.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class PermissionRoleService implements PermissionRoleInterface {

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public void configPermissionRole(PermissionRoleReq permissionRoleReq) {
        //角色名称不为空表示是新增权限并配置菜单权限
        if (StringUtils.isNotEmpty(permissionRoleReq.getRoleName())) {
            RoleReq roleReq = new RoleReq();
            roleReq.setCodeNo(permissionRoleReq.getRoleId());
            roleReq.setCodeName(permissionRoleReq.getRoleName());
            roleService.addRole(roleReq);
            List<PermissionRole> permissionRoles = permissionRoleReq.getPermissionIdList().stream().map(id -> new PermissionRole(id, permissionRoleReq.getRoleId())).collect(Collectors.toList());
            permissionRoleMapper.insertBatch(permissionRoles);
        }

    }

    @Override
    public List<String> getListByRole(PermissionRole permissionRole) {
        return null;
    }
}
