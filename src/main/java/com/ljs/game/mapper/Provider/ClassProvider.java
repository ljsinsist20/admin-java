package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.ClassQuery;

public class ClassProvider {

    public String list(ClassQuery classQuery) {
        String sql = " select c.`id`, c.`name`, t.`name` AS teacher_name from class c, teacher t where 1 = 1";
        StringBuffer str = new StringBuffer(sql);
        if (classQuery.getName() != null) {
            str.append(" AND c.`name` like concat('%',#{name},'%')");
        }
        str.append(" AND c.tid = t.id ");
        return str.toString();
    }
}
