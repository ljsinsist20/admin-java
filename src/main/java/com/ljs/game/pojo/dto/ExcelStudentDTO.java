package com.ljs.game.pojo.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ljs.game.easyexcel.SexConverter;
import lombok.Data;

@Data
public class ExcelStudentDTO {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = SexConverter.class)
    private Integer sex;

    @ExcelProperty("手机号码")
    private String phone;

    //数据库不存在
    @ExcelProperty("辅导员姓名")
    private String teacherName;

    @ExcelProperty("宿舍名称")
    private String dormName;

    @ExcelProperty("班级名称")
    private String className;

    @ExcelProperty("系名称")
    private String departmentName;

    @ExcelIgnore
    private Integer did;

    @ExcelIgnore
    private Integer cid;
}
