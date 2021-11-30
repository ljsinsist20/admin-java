package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.aop.OperLog;
import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.result.R;
import com.ljs.game.service.AdminService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/core/admin")
@CrossOrigin
public class AdminController {
    @Resource
    private AdminService adminService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageInfo pageInfo = adminService.list(pageNum, pageSize);
        return R.ok().data("pageInfo", pageInfo);
    }

    @PostMapping("/add")
    @OperLog(operModul = "管理员列表", operType = "增加")
    public R add(@RequestBody Admin admin) {
        int count = adminService.add(admin);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        if (count == -1) {
            return R.error().message("用户已存在");
        }
        return R.error().message("添加失败");
    }

    @DeleteMapping("delete/{id}/{role}")
    @OperLog(operModul = "管理员列表", operType = "删除")
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

    @PutMapping("update/{id}/{userName}")
    public R update(@PathVariable("id") Integer id, @PathVariable("userName") String userName) {
        int count = adminService.updateStateById(id);
        if (count == 1) {
            redisTemplate.delete(userName);
            return R.ok().message("解锁成功");
        }
        return R.error().message("解锁失败");
    }
}
