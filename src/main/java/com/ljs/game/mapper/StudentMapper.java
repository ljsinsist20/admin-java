package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.StudentProvider;
import com.ljs.game.pojo.entity.Student;
import com.ljs.game.pojo.query.StudentQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface StudentMapper {

//    @Select(" <script> " +
//            " SELECT s.`name`, s.`sex`, s.`phone`, t.`name` AS teacher_name, d.`name` AS dorm_name, " +
//            " c.`name` AS class_name, de.`name` AS department_name " +
//            " FROM student s, teacher t, dorm d, class c, department de " +
//            " WHERE s.`tid` = t.`id` AND s.`did` = d.`id` AND s.`cid` = c.`id` AND c.`id` = de.`id` " +
//            " </script>")
    @SelectProvider(type = StudentProvider.class, method = "list")
    List<Student> list(@Param("studentQuery") StudentQuery studentQuery);

}
