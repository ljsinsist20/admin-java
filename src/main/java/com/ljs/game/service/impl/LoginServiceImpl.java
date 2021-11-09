package com.ljs.game.service.impl;

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
    public int login(String usrename, String password) {
        Admin admin = loginMapper.find(usrename, password);
        if (admin != null) {
            return 1;
        }
        return 0;
    }
}
