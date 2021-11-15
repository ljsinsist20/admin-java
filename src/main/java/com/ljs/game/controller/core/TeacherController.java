package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/core/teacher")
@CrossOrigin
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum,
                  @PathVariable("pageSize") Integer pageSize,
                  TeacherQuery teacherQuery) {
        PageInfo pageInfo = teacherService.list(pageNum, pageSize, teacherQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    @DeleteMapping("/delete/{id}")
    public R deleteById(@PathVariable("id") Integer id) {
        int count = teacherService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("该老师现在仍是班级辅导员，无法删除");
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<Teacher> list = teacherService.findAll();
        return R.ok().data("teacherNameArr", list);
    }

    @PostMapping("/add")
    public R add(@RequestBody Teacher teacher) {
        int count = teacherService.add(teacher);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @PutMapping("/update/{id}")
    public R update(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {
        int count = teacherService.update(id, teacher);
        if (count == 1) {
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }
}
