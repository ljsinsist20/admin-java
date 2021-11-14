package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select(" select * from admin where user_name = #{username} and pass_word = #{password}")
    Admin find(@Param("username") String username, @Param("password") String password);
}
