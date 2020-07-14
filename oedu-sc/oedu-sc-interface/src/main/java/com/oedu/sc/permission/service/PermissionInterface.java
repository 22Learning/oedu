package com.oedu.sc.permission.service;

import com.oedu.sc.permission.po.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionInterface {

    int add(Permission permission);

    int delete(Long id);

    int update(Permission permission);

    List<Permission> getList();
}
