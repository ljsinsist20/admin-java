package com.ljs.game.service.impl;

import com.ljs.game.mapper.OperationLogMapper;
import com.ljs.game.pojo.log.OperationLog;
import com.ljs.game.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    @Override
    public void insert(OperationLog operlog) {
        operationLogMapper.insert(operlog);
    }
}
