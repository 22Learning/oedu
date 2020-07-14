package com.oedu.sc.permission.web;

import com.oedu.common.result.Result;
import com.oedu.sc.permission.po.Permission;
import com.oedu.sc.permission.service.PermissionInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/sc/permission/")
public class PermissionController {
    @Autowired
    private PermissionInterface permissionInterface;

    @PostMapping("add")
    public Result add(@RequestBody Permission permission) {
        return new Result(permissionInterface.add(permission));
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Permission permission) {
        return new Result(permissionInterface.delete(permission.getOeduPermissionId()));
    }

    @PostMapping("update")
    public Result update(@RequestBody Permission permission) {
        return new Result(permissionInterface.update(permission));
    }

    @PostMapping("list")
    public Result getList() {
        return new Result(permissionInterface.getList());
    }

}
