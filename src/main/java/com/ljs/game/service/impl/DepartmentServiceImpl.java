package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.mapper.DepartmentMapper;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.ClassService;
import com.ljs.game.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ClassMapper classMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, DepartmentQuery departmentQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> list = departmentMapper.list(departmentQuery);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = departmentMapper.findAll();
        return list;
    }

    @Override
    public int delete(Integer id) {
        int num = classMapper.findByDeid(id);
        if (num != 0) {
            return 0;
        }
        int count = departmentMapper.delete(id);
        return count;
    }

    @Override
    public int add(Department department) {
        int count = departmentMapper.add(department);
        return count;
    }


}
