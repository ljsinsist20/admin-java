package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select(" select id, name, sex, phone from teacher ")
    List<Teacher> list();
}
