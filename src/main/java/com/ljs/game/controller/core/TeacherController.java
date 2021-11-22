package com.ljs.game.controller.core;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.ljs.game.exception.BusinessException;
import com.ljs.game.pojo.dto.ExcelStudentDTO;
import com.ljs.game.pojo.dto.ExcelTeacherDTO;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.query.TeacherQuery;
import com.ljs.game.result.R;
import com.ljs.game.result.ResponseEnum;
import com.ljs.game.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
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

    /**
     * 导出excel
     * @param response
     */
    @GetMapping("/down/{pageNum}/{pageSize}")
    public void down(@PathVariable("pageNum") Integer pageNum,
                     @PathVariable("pageSize") Integer pageSize,
                     TeacherQuery teacherQuery,
                     HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = new String("导出excel.xlsx".getBytes(), StandardCharsets.ISO_8859_1);
            response.setHeader("Content-disposition", "attachment;filename=" + fileName );
            EasyExcel.write(response.getOutputStream(), ExcelTeacherDTO.class)
                    .sheet("辅导员信息")
                    .doWrite(teacherService.listByDown(pageNum,pageSize, teacherQuery));
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.EXPORT_DATA_ERROR, e);
        }
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
