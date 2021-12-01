package com.ljs.game.pojo.dto.upload;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ljs.game.easyexcel.SexConverter;
import lombok.Data;
import org.springframework.cache.annotation.CacheEvict;

@Data
public class ExcelClassUploadDTO {

    @ExcelProperty(value = "班级名称")
    private String name;

    @ExcelProperty(value = "系名称")
    private String departmentName;

    @ExcelIgnore
    private Integer deid;

    @ExcelProperty(value = "辅导员姓名")
    private String teacherName;

    @ExcelIgnore
    private Integer tid;
}
