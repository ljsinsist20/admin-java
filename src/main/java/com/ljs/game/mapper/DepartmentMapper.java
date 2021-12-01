package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.DepartmentProvider;
import com.ljs.game.pojo.dto.upload.ExcelDepartmentUploadDTO;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @SelectProvider(type = DepartmentProvider.class, method = "list")
    List<Department> list(DepartmentQuery departmentQuery);

    @Select(" SELECT id, name FROM department ")
    List<Department> findAll();

    @Delete(" delete from department  where id = #{id} ")
    int delete(Integer id);

    @Insert(" INSERT INTO department(`name`) VALUES(#{name}) ")
    int add(Department department);

    @Update(" update department set `name` = #{name} where id = #{id} ")
    int update(Department department);

    @Insert(" INSERT INTO department(`name`) VALUES(#{name}) ")
    void addExcel(ExcelDepartmentUploadDTO excelDepartmentUploadDTO);

}
