package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.TeacherQuery;

public class TeacherProvider {

    public String list(TeacherQuery teacherQuery) {
        String sql = " select id, name, sex, phone from teacher ";
        StringBuffer str = new StringBuffer(sql);
        if (teacherQuery.getName() != null) {
            str.append(" WHERE name like concat('%',#{name},'%') ");
        }
        return str.toString();
    }
}
