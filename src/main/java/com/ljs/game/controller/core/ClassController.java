package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Class;
import com.ljs.game.pojo.query.ClassQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.ClassService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/core/class")
@CrossOrigin
public class ClassController {

    @Resource
    private ClassService classService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   ClassQuery classQuery) {
        PageInfo pageInfo = classService.list(pageNum, pageSize, classQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    @DeleteMapping("/delete/{id}")
    public R deleteById(@PathVariable("id") Integer id) {
        int count = classService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("该班级下存在学生，无法删除");
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<Class> list = classService.findAll();
        return R.ok().data("classNameArr", list);
    }

    @PostMapping("add")
    public R add(@RequestBody Class Class) {
        int count = classService.add(Class);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }
}
