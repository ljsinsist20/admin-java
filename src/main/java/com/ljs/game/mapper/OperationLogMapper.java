package com.ljs.game.mapper;

import com.ljs.game.pojo.log.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {

    @Insert(" INSERT INTO `log`(modul, `type`, `desc`, create_time) " +
            " VALUES(#{modul}, #{type}, #{desc}, #{createTime}) ")
    void insert(OperationLog operlog);


}
