package com.ljs.game.pojo.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer sex;
    private String phone;
    private Integer did;
    private Integer cid;
    //数据库不存在
    private String teacherName;
    private String dormName;
    private String className;
    private String departmentName;
}
