package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.DepartmentQuery;

public interface DepartmentService {
    PageInfo list(Integer pageNum, Integer pageSize, DepartmentQuery departmentQuery);
}
