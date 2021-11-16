package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;

import java.util.List;

public interface DepartmentService {
    PageInfo list(Integer pageNum, Integer pageSize, DepartmentQuery departmentQuery);

    List<Department> findAll();

    int delete(Integer id);

    int add(Department department);

    int update(Integer id, Department department);
}
