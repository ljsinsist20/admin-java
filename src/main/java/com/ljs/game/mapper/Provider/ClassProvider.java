package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.ClassQuery;

public class ClassProvider {

    public String list(ClassQuery classQuery) {
        String sql = " select id, name from class ";
        StringBuffer str = new StringBuffer(sql);
        if (classQuery.getName() != null) {
            str.append(" WHERE name like concat('%',#{name},'%')");
        }
        return str.toString();
    }
}
