package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.ClassQuery;

public interface ClassService {
    PageInfo list(Integer pageNum, Integer pageSize, ClassQuery classQuery);

    int deleteById(Integer id);
}
