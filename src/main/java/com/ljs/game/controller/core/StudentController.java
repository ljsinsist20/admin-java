package com.ljs.game.controller.core;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.ljs.game.aop.OperLog;
import com.ljs.game.exception.BusinessException;
import com.ljs.game.pojo.dto.down.ExcelStudentDTO;
import com.ljs.game.pojo.query.StudentQuery;
import com.ljs.game.pojo.vo.StudentVO;
import com.ljs.game.result.R;
import com.ljs.game.result.ResponseEnum;
import com.ljs.game.service.StudentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

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
    public R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   StudentQuery studentQuery) {
        PageInfo pageInfo = studentService.list(pageNum, pageSize, studentQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    /**
     * 导出excel
     * @param response
     */
    @GetMapping("/down/{pageNum}/{pageSize}")
    public void down(@PathVariable("pageNum") Integer pageNum,
                     @PathVariable("pageSize") Integer pageSize,
                     StudentQuery studentQuery,
                     HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = new String("导出excel.xlsx".getBytes(), StandardCharsets.ISO_8859_1);
            response.setHeader("Content-disposition", "attachment;filename=" + fileName );
            EasyExcel.write(response.getOutputStream(), ExcelStudentDTO.class)
                    .sheet("学生信息")
                    .doWrite(studentService.listByDown(pageNum,pageSize, studentQuery));
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.EXPORT_DATA_ERROR, e);
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @OperLog(operModul = "学生列表", operType = "删除")
    public R deleteById(@PathVariable("id") Integer id) {
        int count = studentService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    @PostMapping("/add")
    public R add(@RequestBody StudentVO studentVO) {
        int count = studentService.add(studentVO);
        if (count == 1) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @PutMapping("/update/{id}")
    public R update(@PathVariable("id") Integer id, @RequestBody StudentVO studentVO) {
        int count = studentService.update(id, studentVO);
        if (count == 1) {
            return R.ok().message("更新成功");
        }
        return R.error().message("更新失败");
    }
}
