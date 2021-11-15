package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.mapper.StudentMapper;
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
}
