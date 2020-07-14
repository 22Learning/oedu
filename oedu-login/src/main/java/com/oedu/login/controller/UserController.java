package com.oedu.login.controller;

import com.oedu.common.result.Result;
import com.oedu.login.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login/user/")
public class UserController {

    @Autowired
    private UserInterface userInterface;

    /**
     * 通过用户编号获取用户名
     * 此处的用户编号就是电话号码
     * @param userIds
     * @return
     */
    @PostMapping("getNameByIds")
    public Result getNameByIds(List<String> userIds) {
        return new Result(userInterface.getNameByIds(userIds));
    }

}
