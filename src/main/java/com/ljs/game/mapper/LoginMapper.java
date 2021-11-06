package com.ljs.game.mapper;

import com.ljs.game.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface LoginMapper {

    @Select(" select * from admin where user_name = #{username} and pass_word = #{password}")
    Admin find(String username, String password);
}
