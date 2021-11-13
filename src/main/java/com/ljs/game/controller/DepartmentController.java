package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.DepartmentQuery;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/core/department")
@CrossOrigin
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    private R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   DepartmentQuery departmentQuery) {
        PageInfo pageInfo = departmentService.list(pageNum, pageSize, departmentQuery);
        return R.ok().data("pageInfo", pageInfo);
    }
}
