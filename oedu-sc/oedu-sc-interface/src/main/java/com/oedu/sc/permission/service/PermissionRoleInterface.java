package com.oedu.sc.permission.service;

import com.oedu.sc.permission.dto.PermissionRoleReq;
import com.oedu.sc.permission.po.PermissionRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionRoleInterface {


    void configPermissionRole(PermissionRoleReq permissionRoleReq);

    List<String> getListByRole(PermissionRole permissionRole);
}
