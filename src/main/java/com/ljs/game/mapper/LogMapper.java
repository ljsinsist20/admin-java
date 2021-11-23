package com.ljs.game.mapper;

import com.ljs.game.mapper.Provider.LogProvider;
import com.ljs.game.pojo.entity.Log;
import com.ljs.game.pojo.query.LogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface LogMapper {

//    @Select(" SELECT id, modul, `type`, `desc`, create_time FROM `log` ")
    @SelectProvider(type = LogProvider.class, method = "list")
    List<Log> list(LogQuery logQuery);

}
