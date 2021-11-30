package com.ljs.game.pojo.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String userName;

    private String passWord;

    private String role;

    private Integer state;

}
