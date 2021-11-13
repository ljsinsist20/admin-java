package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.ClassProvider;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ClassMapper {

    @SelectProvider(type = ClassProvider.class, method = "list")
    List<Class> list(ClassQuery classQuery);

    @Delete(" delete from class where id = #{id} ")
    int deleteById(Integer id);

    @Select(" select id, name from class ")
    List<Class> findAll();

}
