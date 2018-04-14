package com.mengyirunian.controller;

import com.mengyirunian.dao.WeixinDao;
import com.mengyirunian.entity.Gxjs;
import com.mengyirunian.utils.JSONUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@RestController
@Api(description = "Index")
@Slf4j
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private WeixinDao weixinDao;

    @RequestMapping(value = "/accesswx", method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam("name") String name) throws Exception {
        List<Gxjs> gxjsList = weixinDao.getGxjsList(name);
        return JSONUtils.list2json(gxjsList);
    }

}
