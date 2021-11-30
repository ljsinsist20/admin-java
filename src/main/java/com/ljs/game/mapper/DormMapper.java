package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.DormProvider;
import com.ljs.game.pojo.dto.upload.ExcelDormUploadDTO;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormMapper {

    @SelectProvider(type = DormProvider.class, method = "list")
    List<Dorm> list(DormQuery dormQuery);

    @Delete(" delete from dorm where id = #{id} ")
    int deleteById(Integer id);

    @Select(" SELECT id, NAME FROM dorm ")
    List<Dorm> findAll();

    @Delete(" delete from dorm  where id = #{id} ")
    int delete(Integer id);

    @Insert(" INSERT INTO dorm(`name`) VALUES(#{name}) ")
    int add(Dorm dorm);

    @Update(" update dorm set `name` = #{name} where id = #{id} ")
    int update(Dorm dorm);

    @Insert(" INSERT INTO dorm(`name`) VALUES(#{name}) ")
    void addExcel(ExcelDormUploadDTO excelDormUploadDTO);
}
