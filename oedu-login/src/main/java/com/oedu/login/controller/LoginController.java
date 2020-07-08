package com.oedu.login.controller;

import com.oedu.login.dto.ResponseEntity;
import com.oedu.login.service.LoginService;
import com.oedu.login.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("login")
    public ResponseEntity logIn(String phone,String password){
        if(StringUtils.isEmpty(password)){
            return ResponseEntity.error("密码必填!");
        }
        return loginService.login(phone,password);

    }


    @GetMapping("logout")
    public String logOut(){
        System.out.println("ok");
        return "ok";
    }
}
