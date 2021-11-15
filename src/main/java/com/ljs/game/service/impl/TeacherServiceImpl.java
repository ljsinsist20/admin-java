package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.mapper.TeacherMapper;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import com.ljs.game.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private ClassMapper classMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.list(teacherQuery);
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer tid) {
        int num = classMapper.findByTid(tid);
        if (num != 0) {
            return 0;
        }
        int count = teacherMapper.deleteById(tid);
        return count;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> list = teacherMapper.findAll();
        return list;
    }
}
