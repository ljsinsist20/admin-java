package com.ljs.game.pojo.dto.upload;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ljs.game.easyexcel.SexConverter;
import lombok.Data;

@Data
public class ExcelStudentUploadDTO {

    @ExcelProperty(value = "学生姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = SexConverter.class)
    private Integer sex;

    @ExcelProperty(value = "电话号码")
    private String phone;

    @ExcelProperty(value = "班级名称")
    private String className;

    @ExcelIgnore
    private Integer cid;

    @ExcelProperty(value = "宿舍名称")
    private String dormName;

    @ExcelIgnore
    private Integer did;
}
