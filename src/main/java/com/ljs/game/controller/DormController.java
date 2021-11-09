package com.ljs.game.controller;

import com.github.pagehelper.PageInfo;
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
    private R list(@PathVariable("pageNum") Integer pageNum,
                   @PathVariable("pageSize") Integer pageSize,
                   DormQuery dormQuery) {
        PageInfo pageInfo = dormService.list(pageNum, pageSize, dormQuery);
        return R.ok().data("pageInfo", pageInfo);
    }
}
