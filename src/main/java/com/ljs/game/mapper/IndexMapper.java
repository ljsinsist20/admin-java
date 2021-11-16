package com.ljs.game.mapper;

import com.ljs.game.pojo.vo.SexVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IndexMapper {

    @Select(" SELECT COUNT(*) AS boyNum, (SELECT COUNT(*) FROM student) AS allNum FROM student WHERE sex = 0 ")
    SexVO findSex();

}
