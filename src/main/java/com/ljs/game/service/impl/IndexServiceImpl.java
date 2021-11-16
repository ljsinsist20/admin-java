package com.ljs.game.service.impl;

import com.ljs.game.mapper.IndexMapper;
import com.ljs.game.pojo.vo.SexVO;
import com.ljs.game.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    public SexVO findSex() {
        SexVO sexVO = indexMapper.findSex();
        sexVO.setGirlNum(sexVO.getAllNum() - sexVO.getBoyNum());
        return sexVO;
    }
}
