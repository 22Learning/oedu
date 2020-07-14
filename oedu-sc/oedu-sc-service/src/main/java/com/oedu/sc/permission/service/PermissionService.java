package com.oedu.sc.permission.service;
import com.oedu.common.entities.LogicException;
import com.oedu.common.tools.StringUtils;
import com.oedu.common.tools.UserUtil;
import com.oedu.sc.permission.dao.PermissionMapper;
import com.oedu.sc.permission.po.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class PermissionService implements PermissionInterface {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int add(Permission permission) {
        permission.setOeduPermissionId(null);
        permission.setStatus(1);
        permission.setCreateTime(new Date());
        permission.setCreateUser(UserUtil.getUserId());
        permission.setUpdateTime(new Date());
        permission.setUpdateUser(UserUtil.getUserId());
        return permissionMapper.insert(permission);
    }
    @Override
    public int delete(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new LogicException("参数缺失，无法删除");
        }
        Permission permission = new Permission();
        permission.setUpdateTime(new Date());
        permission.setUpdateUser(UserUtil.getUserId());
        permission.setStatus(0);
        permission.setOeduPermissionId(id);
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int update(Permission permission) {
        delete(permission.getOeduPermissionId());
        return add(permission);
    }

    @Override
    public List<Permission> getList() {
        return permissionMapper.selectList();
    }
}

