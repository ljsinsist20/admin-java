package com.ljs.game.controller;

import com.ljs.game.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public int login(String usrename, String password) {
        int i = loginService.login(usrename, password);
        return i;
    }
}
