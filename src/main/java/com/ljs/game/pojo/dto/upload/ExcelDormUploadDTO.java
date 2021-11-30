package com.ljs.game.pojo.dto.upload;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelDormUploadDTO {

    @ExcelProperty(value = "宿舍名称")
    private String name;
}
