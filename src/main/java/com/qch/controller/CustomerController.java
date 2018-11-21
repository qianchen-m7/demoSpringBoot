package com.qch.controller;

import com.qch.service.FileService;
import com.qch.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by BF100499 on 2018/11/1.
 */
@RestController
public class CustomerController {
    @Autowired
    private RedisService redisService ;

    @Autowired
    private FileService fileService;

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
        redisService.set("name1","qianchen");
        mode.setViewName("emailTemplate");

        return mode;
    }

    @RequestMapping(value="/up")
    @ResponseBody
    public String up(@RequestParam("myfile")MultipartFile file){

      return fileService.fileUpload(file);
    }

    @RequestMapping(value="/down")
    @ResponseBody
    public String up(HttpServletResponse response){

        return fileService.download(response);
    }

    @RequestMapping(value="/vue")
    @ResponseBody
    public ModelAndView goVue(){


        ModelAndView mode = new ModelAndView();
        mode.setViewName("vue");
        return mode;
    }

}
