package com.qch.controller;

import com.qch.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by BF100499 on 2018/11/1.
 */
@RestController
public class CustomerController {
    @Autowired
    private RedisService redisService ;


    @RequestMapping("/hello")
    public String index()
    {
        return  "hello word";
    }

    @RequestMapping(value="/tem")
    @ResponseBody
    public ModelAndView goHome(){

        System.out.println("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        redisService.set("name","zhangsan");
        mode.setViewName("emailTemplate");

        return mode;
    }

}
