package org.mall.manager.controller;

import org.mall.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping("/queryDate")
    @ResponseBody
    public String queryDate(){
        String s = service.queryData();

        return s;
    }
}
