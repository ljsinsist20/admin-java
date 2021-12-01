package com.ljs.game.pojo.dto.upload;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelDepartmentUploadDTO {

    @ExcelProperty(value = "系名称")
    private String name;
}
