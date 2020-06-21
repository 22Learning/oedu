package com.oedu.login.controller;

import com.oedu.login.entities.ResponseEntity;
import com.oedu.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("login")
    public ResponseEntity logIn(String phone,String password){
        return loginService.login(phone,password);

    }


    @GetMapping("logout")
    public String logOut(){
        System.out.println("ok");
        return "ok";
    }
}
