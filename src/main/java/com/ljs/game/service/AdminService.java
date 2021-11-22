package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Admin;

public interface AdminService {
    PageInfo list(Integer pageNum, Integer pageSize);

    int add(Admin admin);

    int delete(Integer id, String role);
}
