package com.ljs.game.service;

import com.github.pagehelper.PageInfo;

public interface DormService {
    PageInfo list(Integer pageNum, Integer pageSize);

}
