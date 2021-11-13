package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.exception.Assert;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.vo.StudentVO;
import com.ljs.game.result.R;
import com.ljs.game.service.StudentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/core/student")
@CrossOrigin
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 查询
     * @param pageNum
     * @param pageSize
     * @param studentQuery
     * @return
     */
    @GetMapping("/list/{pageNum}/{pageSize}")
    private R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   StudentQuery studentQuery) {
        PageInfo pageInfo = studentService.list(pageNum, pageSize, studentQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    private R deleteById(@PathVariable("id") Integer id) {
        int count = studentService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    @PostMapping("/add")
    private R add(@RequestBody StudentVO studentVO) {
        int count = studentService.add(studentVO);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }
}
