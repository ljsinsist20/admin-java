package com.ljs.game.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.listener.ExcelDormUploadDTOListener;
import com.ljs.game.listener.ExcelTeacherUploadDTOListener;
import com.ljs.game.mapper.ClassMapper;
import com.ljs.game.mapper.TeacherMapper;
import com.ljs.game.pojo.dto.down.ExcelTeacherDTO;
import com.ljs.game.pojo.dto.upload.ExcelDormUploadDTO;
import com.ljs.game.pojo.dto.upload.ExcelTeacherUploadDTO;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import com.ljs.game.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private ClassMapper classMapper;

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.list(teacherQuery);
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List listByDown(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.list(teacherQuery);
        ArrayList<ExcelTeacherDTO> teaList = new ArrayList<>(list.size());
        for (Teacher item : list) {
            ExcelTeacherDTO excelTeacherDTO = new ExcelTeacherDTO();
            BeanUtils.copyProperties(item, excelTeacherDTO);
            teaList.add(excelTeacherDTO);
        }
        return teaList;
    }

    @Override
    public int deleteById(Integer tid) {
        int num = classMapper.findByTid(tid);
        if (num != 0) {
            return 0;
        }
        int count = teacherMapper.deleteById(tid);
        return count;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> list = teacherMapper.findAll();
        return list;
    }

    @Override
    public int add(Teacher teacher) {
        int count = teacherMapper.add(teacher);
        return count;
    }

    @Override
    public int update(Integer id, Teacher teacher) {
        teacher.setId(id);
        int count = teacherMapper.update(teacher);
        return count;
    }

    @Override
    public void addExcel(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelTeacherUploadDTO.class, new ExcelTeacherUploadDTOListener(teacherMapper)).sheet().doRead();
    }
}
