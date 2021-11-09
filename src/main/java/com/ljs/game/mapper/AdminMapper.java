package com.ljs.game.mapper;

import com.ljs.game.pojo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select(" SELECT id, user_name, pass_word FROM admin ")
    List<Admin> list();
}
