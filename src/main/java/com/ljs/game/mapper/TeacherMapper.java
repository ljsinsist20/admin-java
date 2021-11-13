package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.TeacherProvider;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @SelectProvider(type = TeacherProvider.class, method = "list")
    List<Teacher> list(TeacherQuery teacherQuery);

    @Delete(" delete from teacher where id = #{id}  ")
    int deleteById(Integer id);

    @Select(" SELECT id, NAME FROM teacher ")
    List<Teacher> findAll();

}
