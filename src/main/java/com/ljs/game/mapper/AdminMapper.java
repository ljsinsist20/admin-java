package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select(" SELECT id, user_name, pass_word, role, state FROM admin ")
    List<Admin> list();

    @Insert(" INSERT INTO admin(user_name, pass_word, role, state) VALUES(#{userName}, #{passWord}, #{role}, 0) ")
    int add(@Param("userName") String userName, @Param("passWord") String passWord, String role);

    @Delete(" DELETE FROM admin WHERE id = #{id} ")
    int delete(@Param("id") Integer id);

    @Select(" SELECT COUNT(*) FROM admin WHERE role = 'administrator' ")
    int findByAdmin();

    @Select(" SELECT COUNT(*) FROM admin WHERE user_name = #{userName} ")
    int findByName(@Param("userName")String userName);

    @Update(" UPDATE admin SET state = 1 WHERE user_name = #{userName} ")
    void updateState(@Param("userName")String userName);

    @Update(" UPDATE admin SET state = 0 WHERE id = #{id} ")
    int updateStateById(Integer id);
}
