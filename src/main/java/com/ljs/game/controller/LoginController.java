package com.ljs.game.controller;

import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.result.R;
import com.ljs.game.service.LoginService;
import com.ljs.game.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public R login(@RequestBody Admin admin) {
        Admin adminFlag = loginService.login(admin.getUserName(), admin.getPassWord());
        if (adminFlag != null) {
            String token = JwtUtils.createToken(adminFlag.getId(), adminFlag.getUserName());
            return R.ok().data("token", token);
        }
        return R.error().message("用户不存在");
    }
}
