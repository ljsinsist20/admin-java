package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.aop.OperLog;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.DormService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/core/dorm")
@CrossOrigin
public class DormController {

    @Resource
    private DormService dormService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum,
                  @PathVariable("pageSize") Integer pageSize,
                  DormQuery dormQuery) {
        PageInfo pageInfo = dormService.list(pageNum, pageSize, dormQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    @DeleteMapping("/delete/{id}")
    @OperLog(operModul = "宿舍列表", operType = "删除")
    public R deleteById(@PathVariable("id") Integer id) {
        int count = dormService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("该宿舍下存在学生，无法删除");
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<Dorm> list = dormService.findAll();
        return R.ok().data("dormNameArr", list);
    }

    @PostMapping("/add")
    @OperLog(operModul = "宿舍列表", operType = "增加")
    public R add(@RequestBody Dorm dorm) {
        int count = dormService.add(dorm);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @PutMapping("/update/{id}")
    @OperLog(operModul = "宿舍列表", operType = "更新")
    public R update(@PathVariable("id") Integer id, @RequestBody Dorm dorm) {
        int count = dormService.update(id, dorm);
        if (count == 1) {
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }
}
