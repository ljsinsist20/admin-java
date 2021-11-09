package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.StudentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.SQLOutput;

@RestController
@RequestMapping("/core/student")
@CrossOrigin
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    private R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   StudentQuery studentQuery) {
        PageInfo pageInfo = studentService.list(pageNum, pageSize, studentQuery);
        return R.ok().data("pageInfo", pageInfo);
    }
}
