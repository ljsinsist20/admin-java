package com.ljs.game.controller.core;

import com.ljs.game.pojo.vo.SexVO;
import com.ljs.game.result.R;
import com.ljs.game.service.IndexService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/core/index")
@CrossOrigin
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping("/sex")
    public R findSex() {
        SexVO sexVO = indexService.findSex();
        return R.ok().data("sexVO", sexVO);
    }
}
