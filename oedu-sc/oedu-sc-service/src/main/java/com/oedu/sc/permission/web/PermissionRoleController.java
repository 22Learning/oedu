package com.oedu.sc.permission.web;

import com.oedu.common.result.Result;
import com.oedu.sc.permission.dto.PermissionRoleReq;
import com.oedu.sc.permission.po.PermissionRole;
import com.oedu.sc.permission.service.PermissionRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/permission/role/")
public class PermissionRoleController {

    @Autowired
    private PermissionRoleInterface permissionRoleInterface;

    @PostMapping("config")
    public Result configPermissionRole(@RequestBody PermissionRoleReq permissionRoleReq) {
        permissionRoleInterface.configPermissionRole(permissionRoleReq);
        return new Result();
    }

    @PostMapping("list")
    public Result getListByRole(@RequestBody PermissionRole permissionRole) {
        return new Result(permissionRoleInterface.getListByRole(permissionRole));
    }

}
