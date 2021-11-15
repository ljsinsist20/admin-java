package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/core/department")
@CrossOrigin
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   DepartmentQuery departmentQuery) {
        PageInfo pageInfo = departmentService.list(pageNum, pageSize, departmentQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<Department> list = departmentService.findAll();
        return R.ok().data("departmentNameArr", list);
    }
}
