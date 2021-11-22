package com.ljs.game.pojo.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ljs.game.easyexcel.SexConverter;
import lombok.Data;

@Data
public class ExcelTeacherDTO {

    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "辅导员姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = SexConverter.class)
    private Integer sex;

    @ExcelProperty("手机号码")
    private String phone;
}
