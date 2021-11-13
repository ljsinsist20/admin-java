package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.DormMapper;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.service.DormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormServiceImpl implements DormService {

    @Resource
    private DormMapper dormMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, DormQuery dormQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dorm> list = dormMapper.list(dormQuery);
        PageInfo<Dorm> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
        int count = dormMapper.deleteById(id);
        return count;
    }

    @Override
    public List<Dorm> findAll() {
        List<Dorm> list = dormMapper.findAll();
        return list;
    }
}
