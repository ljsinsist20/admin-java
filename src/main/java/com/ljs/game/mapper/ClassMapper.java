package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.ClassProvider;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {

    @SelectProvider(type = ClassProvider.class, method = "list")
    List<Class> list(ClassQuery classQuery);

    @Delete(" delete from class where id = #{id} ")
    int deleteById(Integer id);

    @Select(" select id, name from class ")
    List<Class> findAll();

    @Select(" select count(*) from class where tid = #{tid} ")
    int findByTid(@Param("tid") Integer tid);

    @Insert(" INSERT INTO class(`name`, deid, tid) VALUES(#{name}, #{deid}, #{tid}) ")
    int add(Class aClass);

    @Update(" UPDATE class SET `name` = #{name}, deid = #{deid}, tid = #{tid} WHERE id = #{id} ")
    int update(Class aClass);

    @Select(" select count(*) from class where deid = #{deid}  ")
    int findByDeid(@Param("deid") Integer deid);
}
