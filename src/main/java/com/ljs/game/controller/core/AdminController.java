package com.ljs.game.controller.core;

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
    public R list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageInfo pageInfo = adminService.list(pageNum, pageSize);
        return R.ok().data("pageInfo", pageInfo);
    }

    @PostMapping("/add")
    public R add(@RequestBody Admin admin) {
        int count = adminService.add(admin);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @DeleteMapping("delete/{id}/{role}")
    public R delete(@PathVariable("id") Integer id, @PathVariable("role") String role) {
        int count = adminService.delete(id, role);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        if (count == 2) {
            return R.error().message("只剩一个[超级管理员]用户无法删除");
        }
        return R.error().message("删除失败");
    }
}
