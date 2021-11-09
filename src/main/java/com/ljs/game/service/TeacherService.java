package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    PageInfo list(Integer pageNum, Integer pageSize);

}
