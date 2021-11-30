package com.ljs.game.controller;

import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.result.R;
import com.ljs.game.service.LoginService;
import com.ljs.game.utils.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public R login(@RequestBody Admin admin) {
        Admin adminFlag = loginService.login(admin.getUserName(), admin.getPassWord());
        if (adminFlag != null) {
            String token = JwtUtils.createToken(adminFlag.getId(), adminFlag.getUserName());
            return R.ok().data("token", token);
        }
        Integer a = (Integer) redisTemplate.opsForValue().get(admin.getUserName());
        if (a == null) {
            a = 0;
            redisTemplate.opsForValue().set(admin.getUserName(), a, 30, TimeUnit.MINUTES);
        }
        if (a < 5) {
            a++;
            redisTemplate.opsForValue().set(admin.getUserName(), a, 30, TimeUnit.MINUTES);
        } else {
            return R.error().message("当前用户锁定");
        }
        return R.error().message("用户名或密码错误");
    }

    @GetMapping("/logout")
    public R logout() {
        return R.ok().code(20000).message("success");
    }


    @GetMapping("/query")
    public R query(@RequestParam("token") String token) {
        Map<String, String> userAll = new HashMap<>();
        String userName = JwtUtils.getUserName(token);
        String role = loginService.findRole(userName);
        userAll.put("userName", userName);
        userAll.put("roles", role);
        return R.ok().data("userAll", userAll);
    }
}
