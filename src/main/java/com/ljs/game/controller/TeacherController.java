package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Teacher;
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
    private R list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize ) {
        PageInfo pageInfo = teacherService.list(pageNum, pageSize);
        return R.ok().data("pageInfo", pageInfo);
    }
}
