package com.mengyirunian.controller;

import com.mengyirunian.service.interfaces.WeixinService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@RestController
@Api(description = "Index")
@Slf4j
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private WeixinService weixinService;

    @RequestMapping(value = "/accesswx", method = RequestMethod.GET)
    @ResponseBody
    public String testMsg(@RequestParam("name") String name) {
        return weixinService.testName(name);
    }

}
