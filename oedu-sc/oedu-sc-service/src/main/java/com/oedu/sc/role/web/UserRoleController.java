package com.oedu.sc.role.web;

import com.oedu.common.result.Result;
import com.oedu.sc.role.po.UserRole;
import com.oedu.sc.role.service.UserRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sc/roleUser/")
public class UserRoleController {

    @Autowired
    private UserRoleInterface userRoleInterface;

    @PostMapping("add")
    public Result addUserRole(UserRole req) {
        return new Result(userRoleInterface.addUserRole(req));
    }

    @PostMapping("delete")
    public Result deleteUserRole(UserRole req) {
        userRoleInterface.deleteUserRole(req.getOeduUserRoleId());
        return new Result();
    }

    @PostMapping("update")
    public Result updateUserRole(UserRole req) {
        userRoleInterface.updateUserRole(req);
        return new Result();
    }

    @PostMapping("list")
    public Result getEffectiveList() {
        return new Result(userRoleInterface.getEffectiveList());
    }
}
