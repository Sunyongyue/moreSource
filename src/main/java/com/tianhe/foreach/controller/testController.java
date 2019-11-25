package com.tianhe.foreach.controller;

import com.tianhe.foreach.entity.test;
import com.tianhe.foreach.service.testService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public  class  testController {
    @Resource
    testService testService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        List<test> queryall = testService.queryall();
        System.out.println(queryall);
        return "123";
    }
    @RequestMapping("/xutest")
    @ResponseBody
    public String xutest(){
        List<test> queryall = testService.queryxu();
        System.out.println(queryall);
        return "123";
    }
}
