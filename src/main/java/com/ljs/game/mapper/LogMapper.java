package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select(" SELECT id, modul, `type`, `desc`, create_time FROM `log` ")
    List<Log> list();

}
