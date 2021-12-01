package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;

import java.io.InputStream;
import java.util.List;

public interface ClassService {
    PageInfo list(Integer pageNum, Integer pageSize, ClassQuery classQuery);

    int deleteById(Integer id);

    List<Class> findAll();

    int add(Class aClass);

    int update(Integer id, Class aClass);

    void addExcel(InputStream inputStream);
}
