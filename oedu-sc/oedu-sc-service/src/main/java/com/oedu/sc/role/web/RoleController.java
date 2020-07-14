package com.oedu.sc.role.web;

import com.oedu.common.result.Result;
import com.oedu.sc.role.dto.RoleReq;
import com.oedu.sc.role.service.RoleInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sc/role/")
public class RoleController {

    @Autowired
    private RoleInterface roleInterface;

    @PostMapping("add")
    public Result addRole(@RequestBody RoleReq req) {
        return new Result(roleInterface.addRole(req));
    }

    @PostMapping("delete")
    public Result deleteRole(@RequestBody RoleReq req) {
        return new Result(roleInterface.deleteRole(req));
    }

    @PostMapping("update")
    public Result updateRole(@RequestBody RoleReq req) {
        return new Result(roleInterface.updateRole(req));
    }

    @PostMapping("list")
    public Result getList() {
        return new Result(roleInterface.getList());
    }
}
