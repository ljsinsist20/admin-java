package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.TeacherQuery;

public interface TeacherService {
    PageInfo list(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery);

}
