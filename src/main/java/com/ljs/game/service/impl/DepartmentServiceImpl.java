package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.DepartmentMapper;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
import com.ljs.game.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, DepartmentQuery departmentQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> list = departmentMapper.list(departmentQuery);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
