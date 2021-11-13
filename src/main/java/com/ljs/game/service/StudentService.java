package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.StudentQuery;


public interface StudentService {
    PageInfo list(Integer pageNum, Integer pageSize, StudentQuery studentQuery);

    int deleteById(Integer id);
}
