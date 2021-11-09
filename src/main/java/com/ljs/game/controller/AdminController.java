package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.result.R;
import com.ljs.game.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/core/admin")
@CrossOrigin
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    private R list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize ) {
        PageInfo pageInfo = adminService.list(pageNum, pageSize);
        return R.ok().data("pageInfo", pageInfo);
    }
}
