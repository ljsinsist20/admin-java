package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.aop.OperLog;
import com.ljs.game.pojo.entity.Department;
import com.ljs.game.pojo.query.DepartmentQuery;
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

    @DeleteMapping("/delete/{id}")
    @OperLog(operModul = "系列表", operType = "删除")
    public R delete(@PathVariable("id") Integer id) {
        int count = departmentService.delete(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("该系下存在班级，无法删除");
    }

    @PostMapping("/add")
    @OperLog(operModul = "系列表", operType = "增加")
    public R add(@RequestBody Department department) {
        int count = departmentService.add(department);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @PutMapping("/update/{id}")
    @OperLog(operModul = "系列表", operType = "更新")
    public R update(@PathVariable("id") Integer id, @RequestBody Department department) {
        int count = departmentService.update(id, department);
        if (count == 1) {
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }
}
