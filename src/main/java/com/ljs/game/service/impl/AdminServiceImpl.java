package com.ljs.game.service.impl;

import com.ljs.game.mapper.AdminMapper;
import com.ljs.game.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
}
