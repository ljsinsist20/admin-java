package com.ljs.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.StudentMapper;
import com.ljs.game.pojo.entity.Student;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.vo.StudentVO;
import com.ljs.game.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, StudentQuery studentQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentMapper.list(studentQuery);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteById(Integer id) {
        int count = studentMapper.deleteById(id);
        return count;
    }

    @Override
    public int add(StudentVO studentVO) {
        int count = studentMapper.add(studentVO);
        return count;
    }
}
