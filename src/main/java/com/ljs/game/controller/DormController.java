package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
import com.ljs.game.pojo.entity.Dorm;
import com.ljs.game.pojo.query.DormQuery;
import com.ljs.game.result.R;
import com.ljs.game.service.DormService;
import org.apache.ibatis.annotations.Delete;
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
    private R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   DormQuery dormQuery) {
        PageInfo pageInfo = dormService.list(pageNum, pageSize, dormQuery);
        return R.ok().data("pageInfo", pageInfo);
    }

    @DeleteMapping("/delete/{id}")
    private R deleteById(@PathVariable("id") Integer id) {
        int count = dormService.deleteById(id);
        if (count == 1) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    @GetMapping("/findAll")
    private R findAll() {
        List<Dorm> list = dormService.findAll();
        return R.ok().data("list", list);
    }
}
