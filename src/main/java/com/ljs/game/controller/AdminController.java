package com.ljs.game.controller;

import com.ljs.game.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/core/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

}
