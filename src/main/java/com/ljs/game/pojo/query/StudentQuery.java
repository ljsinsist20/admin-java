package com.ljs.game.pojo.query;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentQuery {

    private String name;
    private Integer sex;
    private String dormName;
    private String className;
    private String departmentName;

}

