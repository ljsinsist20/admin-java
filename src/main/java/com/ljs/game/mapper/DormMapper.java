package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.DormProvider;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DormMapper {

    @SelectProvider(type = DormProvider.class, method = "list")
    List<Dorm> list(DormQuery dormQuery);

    @Delete(" delete from dorm where id = #{id} ")
    int deleteById(Integer id);

    @Select(" SELECT id, NAME FROM dorm ")
    List<Dorm> findAll();

}
