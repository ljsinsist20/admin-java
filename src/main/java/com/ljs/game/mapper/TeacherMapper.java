package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.TeacherProvider;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @SelectProvider(type = TeacherProvider.class, method = "list")
    List<Teacher> list(TeacherQuery teacherQuery);

    @Delete(" delete from teacher where id = #{id}  ")
    int deleteById(Integer id);

    @Select(" SELECT id, name FROM teacher ")
    List<Teacher> findAll();

    @Insert(" INSERT INTO teacher(`name`, sex, phone) VALUES(#{name}, #{sex}, #{phone}) ")
    int add(Teacher teacher);

    @Update(" UPDATE teacher SET `name` = #{name}, sex = #{sex}, phone = #{phone} WHERE id = #{id} ")
    int update(Teacher teacher);
}
