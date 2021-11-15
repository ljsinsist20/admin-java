package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.DepartmentProvider;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @SelectProvider(type = DepartmentProvider.class, method = "list")
    List<Department> list(DepartmentQuery departmentQuery);

    @Select(" SELECT id, name FROM department ")
    List<Department> findAll();
}
