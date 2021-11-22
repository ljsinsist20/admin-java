package com.ljs.game.pojo.log;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLog {

    private Integer id;

    private String modul;
    private String type;
    private String desc;
    private LocalDateTime createTime;
}
