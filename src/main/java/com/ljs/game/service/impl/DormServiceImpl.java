package com.ljs.game.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.listener.ExcelDormUploadDTOListener;
import com.ljs.game.mapper.DormMapper;
import com.ljs.game.mapper.StudentMapper;
import com.ljs.game.pojo.dto.upload.ExcelDormUploadDTO;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.service.DormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class DormServiceImpl implements DormService {

    @Resource
    private DormMapper dormMapper;

    @Resource
    private StudentMapper studentMapper;


    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, DormQuery dormQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dorm> list = dormMapper.list(dormQuery);
        for (Dorm item : list) {
            int dormNum = studentMapper.findByDid(item.getId());
            item.setStudentNum(dormNum);
        }
        PageInfo<Dorm> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
        int num = studentMapper.findByDid(id);
        if (num != 0) {
            return 0;
        }
        int count = dormMapper.delete(id);
        return count;
    }

    @Override
    public List<Dorm> findAll() {
        List<Dorm> list = dormMapper.findAll();
        return list;
    }

    @Override
    public int add(Dorm dorm) {
        int count = dormMapper.add(dorm);
        return count;
    }

    @Override
    public int update(Integer id, Dorm dorm) {
        dorm.setId(id);
        int count = dormMapper.update(dorm);
        return count;
    }

    @Override
    public void addExcel(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDormUploadDTO.class, new ExcelDormUploadDTOListener(dormMapper)).sheet().doRead();
    }
}
