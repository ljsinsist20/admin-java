package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;

import java.util.List;

public interface DormService {
    PageInfo list(Integer pageNum, Integer pageSize, DormQuery dormQuery);

    int deleteById(Integer id);

    List<Dorm> findAll();


}
