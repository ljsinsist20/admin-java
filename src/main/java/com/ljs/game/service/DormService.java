package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.DormQuery;

public interface DormService {
    PageInfo list(Integer pageNum, Integer pageSize, DormQuery dormQuery);

}
