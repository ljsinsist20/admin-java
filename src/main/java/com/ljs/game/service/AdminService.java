package com.ljs.game.service;

import com.github.pagehelper.PageInfo;

public interface AdminService {
    PageInfo list(Integer pageNum, Integer pageSize);
}
