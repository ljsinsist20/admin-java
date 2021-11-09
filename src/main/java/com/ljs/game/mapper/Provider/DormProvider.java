package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.DormQuery;

public class DormProvider {

    public String list(DormQuery dormQuery) {
        String sql = " select id, name from dorm ";
        StringBuffer str = new StringBuffer(sql);
        if (dormQuery.getName() != null) {
            str.append(" WHERE name like concat('%',#{name},'%') ");
        }
        return str.toString();
    }
}
