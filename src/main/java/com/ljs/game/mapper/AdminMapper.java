package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select(" SELECT id, user_name, pass_word, role FROM admin ")
    List<Admin> list();

    @Insert(" INSERT INTO admin(user_name, pass_word) VALUES(#{userName}, #{passWord}) ")
    int add(@Param("userName") String userName, @Param("passWord") String passWord);

    @Delete(" DELETE FROM admin WHERE id = #{id} ")
    int delete(@Param("id") Integer id);
}
