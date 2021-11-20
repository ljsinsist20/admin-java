package com.ljs.game.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.ljs.game.mapper.LoginMapper;
import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public Admin login(String usrename, String password) {
        Admin admin = loginMapper.find(usrename, MD5.create().digestHex(password));
        return admin;
    }

    @Override
    public String findRole(String userName) {
        String role = loginMapper.findRolo(userName);
        return role;
    }
}
