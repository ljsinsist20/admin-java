package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.vo.StudentVO;

import java.io.InputStream;
import java.util.List;


public interface StudentService {
    PageInfo list(Integer pageNum, Integer pageSize, StudentQuery studentQuery);

    int deleteById(Integer id);

    int add(StudentVO studentVO);

    int update(Integer id, StudentVO studentVO);

    List listByDown(Integer pageNum, Integer pageSize, StudentQuery studentQuery);

    void addExcel(InputStream inputStream);

}
