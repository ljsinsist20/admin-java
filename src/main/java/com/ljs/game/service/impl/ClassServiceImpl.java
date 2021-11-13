package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;
import com.ljs.game.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, ClassQuery classQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Class> list = classMapper.list(classQuery);
        PageInfo<Class> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
        int count = classMapper.deleteById(id);
        return count;
    }
}
