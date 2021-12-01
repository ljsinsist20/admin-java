package com.ljs.game.controller.core;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.ljs.game.aop.OperLog;
import com.ljs.game.exception.BusinessException;
import com.ljs.game.pojo.dto.down.ExcelTeacherDTO;
import com.ljs.game.pojo.entity.Teacher;
import com.ljs.game.pojo.query.TeacherQuery;
import com.ljs.game.result.R;
import com.ljs.game.result.ResponseEnum;
import com.ljs.game.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
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
    @OperLog(operModul = "辅导员列表", operType = "删除")
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
    @OperLog(operModul = "辅导员列表", operType = "增加")
    public R add(@RequestBody Teacher teacher) {
        int count = teacherService.add(teacher);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @PutMapping("/update/{id}")
    @OperLog(operModul = "辅导员列表", operType = "更新")
    public R update(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {
        int count = teacherService.update(id, teacher);
        if (count == 1) {
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }

    @PostMapping("/addExcel")
    public R addExcel(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            teacherService.addExcel(inputStream);
            return R.ok().message("批量导入成功");
        }catch (Exception e){
            //UPLOAD_ERROR(-103, "文件上传错误"),
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }
}
