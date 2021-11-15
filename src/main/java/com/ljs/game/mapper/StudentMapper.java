package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.StudentProvider;
import com.ljs.game.pojo.entity.Student;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.vo.StudentVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    //    @Select(" select id, name, sex, phone from student ")
//    @Select(" <script> " +
//            " SELECT s.`name`, s.`sex`, s.`phone`, t.`name` AS teacher_name, d.`name` AS dorm_name, " +
//            " c.`name` AS class_name, de.`name` AS department_name " +
//            " FROM student s, teacher t, dorm d, class c, department de " +
//            " WHERE s.`tid` = t.`id` AND s.`did` = d.`id` AND s.`cid` = c.`id` AND c.`id` = de.`id` " +
//            " </script>")
    @SelectProvider(type = StudentProvider.class, method = "list")
    List<Student> list(@Param("studentQuery") StudentQuery studentQuery);

    @Delete(" delete from student where id = #{id} ")
    int deleteById(@Param("id") Integer id);

    @Insert(" INSERT INTO student(name, sex, phone, did, cid) " +
            " VALUES(#{name}, #{sex}, #{phone}, #{did}, #{cid}) ")
    int add(StudentVO studentVO);

    @Select(" SELECT COUNT(*) FROM student WHERE cid = #{id} ")
    int findByCid(@Param("id") Integer id);

    @Select(" SELECT COUNT(*) FROM student WHERE did = #{id} ")
    int findByDid(@Param("id") Integer id);

    @Update(" UPDATE student SET `name` = #{name}, sex = #{sex}, phone = #{phone}, " +
            " did = #{did}, cid = #{cid}" +
            " WHERE id = #{id} ")
    int update(StudentVO studentVO);

}
