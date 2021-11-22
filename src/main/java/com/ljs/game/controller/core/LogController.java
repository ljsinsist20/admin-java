package com.ljs.game.controller.core;

import com.github.pagehelper.PageInfo;
import com.ljs.game.result.R;
import com.ljs.game.service.LogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/core/log")
@CrossOrigin
public class LogController {

    @Resource
    private LogService logService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public R list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageInfo pageInfo = logService.list(pageNum, pageSize);
        return R.ok().data("pageInfo", pageInfo);
    }
}
