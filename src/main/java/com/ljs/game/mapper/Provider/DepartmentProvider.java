package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;

public class DepartmentProvider {

    public String list(DepartmentQuery departmentQuery) {
        String sql = " select id, name from department ";
        StringBuffer str = new StringBuffer(sql);
        if (departmentQuery.getName() != null) {
            str.append(" where name like concat('%',#{name},'%') ");
        }
        return str.toString();
    }
}
