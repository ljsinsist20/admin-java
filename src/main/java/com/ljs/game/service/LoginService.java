package com.ljs.game.service;

import com.ljs.game.pojo.entity.Admin;

public interface LoginService {
    Admin login(String usrename, String password);

    String findRole(String userName);

}
