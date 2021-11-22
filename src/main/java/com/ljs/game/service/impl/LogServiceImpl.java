package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.LogMapper;
import com.ljs.game.pojo.entity.Log;
import com.ljs.game.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;


    @Override
    public PageInfo list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Log> list = logMapper.list();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
