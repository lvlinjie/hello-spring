package com.spdb.lvlj.doamin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * freemarker  模板使用
 */
@Controller
@RequestMapping("/freemarker")
public class HelloWorldFreemakerController {

    /**
     * 设置数据，返回到freemarker视图
     * @return
     */
    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message", "SpringBoot 大爷你好！");
        mav.setViewName("helloWorld");
        System.out.println("hello world!");
        return mav;
    }
}
