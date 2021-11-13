package com.ljs.game.mapper.Provider;
import com.ljs.game.pojo.query.StudentQuery;

public class StudentProvider {

    public String list(StudentQuery studentQuery){
        String sql =   " SELECT s.`id`, s.`name`, s.`sex`, s.`phone`, t.`name` AS teacher_name, d.`name` AS dorm_name, " +
            " c.`name` AS class_name, de.`name` AS department_name " +
            " FROM student s, teacher t, dorm d, class c, department de " +
            " WHERE s.`tid` = t.`id` AND s.`did` = d.`id` AND s.`cid` = c.`id` AND c.`id` = de.`id` ";
        StringBuffer str = new StringBuffer(sql);
        if (studentQuery.getName() != null) {
            str.append(" AND s.`name` like concat('%',#{studentQuery.name},'%') ");
        }
        if (studentQuery.getSex() != null) {
            str.append(" AND s.`sex` = #{studentQuery.sex}");
        }
        if (studentQuery.getDormName() != null) {
            str.append(" AND d.`name` like concat('%',#{studentQuery.dormName},'%') ");
        }
        if (studentQuery.getClassName() != null) {
            str.append(" AND c.`name` like concat('%',#{studentQuery.className},'%') ");
        }
        if (studentQuery.getDepartmentName() != null) {
            str.append(" AND de.`name` like concat('%',#{studentQuery.departmentName},'%') ");
        }
        return str.toString();
    };
}
