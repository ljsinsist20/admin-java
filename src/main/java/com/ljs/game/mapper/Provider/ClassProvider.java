package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.ClassQuery;

public class ClassProvider {

    public String list(ClassQuery classQuery) {
        String sql = " select c.`id`, t.`id` AS tid, de.`id` AS deid, c.`name`, t.`name` AS teacher_name, de.`name` AS department_name " +
                " from class c, teacher t, department de " +
                " where c.`tid` = t.`id` AND c.`deid` = de.`id` ";
        StringBuffer str = new StringBuffer(sql);
        if (classQuery.getName() != null) {
            str.append(" AND c.`name` like concat('%',#{name},'%') ");
        }
        if (classQuery.getTeacherName() != null) {
            str.append(" AND t.`name` like concat('%',#{teacherName},'%') ");
        }
        if (classQuery.getDepartmentName() != null) {
            str.append(" AND de.`name` like concat('%',#{departmentName},'%') ");
        }
        return str.toString();
    }
}
