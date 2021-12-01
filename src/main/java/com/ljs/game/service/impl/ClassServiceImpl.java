package com.ljs.game.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.listener.ExcelCLassUploadDTOListener;
import com.ljs.game.listener.ExcelDormUploadDTOListener;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.mapper.StudentMapper;
import com.ljs.game.pojo.dto.upload.ExcelClassUploadDTO;
import com.ljs.game.pojo.dto.upload.ExcelDormUploadDTO;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;
import com.ljs.game.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, ClassQuery classQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Class> list = classMapper.list(classQuery);
        //优化建议:使用数据库语句一次性查完
        for (Class item : list) {
            int studentNum = studentMapper.findByCid(item.getId());
            item.setStudentNum(studentNum);
        }
        PageInfo<Class> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
        int num = studentMapper.findByCid(id);
        if (num != 0) {
            return 0;
        }
        int count = classMapper.deleteById(id);
        return count;
    }

    @Override
    public List<Class> findAll() {
        List<Class> list = classMapper.findAll();
        return list;
    }

    @Override
    public int add(Class aClass) {
        int count = classMapper.add(aClass);
        return count;
    }

    @Override
    public int update(Integer id, Class aClass) {
        aClass.setId(id);
        int count = classMapper.update(aClass);
        return count;
    }

    @Override
    public void addExcel(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelClassUploadDTO.class, new ExcelCLassUploadDTOListener(classMapper)).sheet().doRead();
    }
}
