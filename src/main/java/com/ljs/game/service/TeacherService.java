package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;

import java.util.List;

public interface TeacherService {
    PageInfo list(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery);

    int deleteById(Integer id);

    List<Teacher> findAll();

    int add(Teacher teacher);

    int update(Integer id, Teacher teacher);
}
