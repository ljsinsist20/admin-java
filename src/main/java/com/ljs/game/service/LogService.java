package com.ljs.game.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

    PageInfo list(Integer pageNum, Integer pageSize);
}
