package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Dorm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DormMapper {

    @Select(" select id, name from dorm ")
    List<Dorm> list();

}
