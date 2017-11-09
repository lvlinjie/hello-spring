package com.spdb.lvlj.valuee.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test1")
    /**
     * 前端url请求参数名称与方法参数名一致
     * 可以直接从url中获取name pwd的属性值。
     */
    public String test1(String name,String pwd){
        return name+"-------------"+pwd;
    }

    @GetMapping("/test2")
    /**
     * 可以直接从url中获取name pwd的属性值，url参数名和控制器参数名不一样时，可以在控制器参数名之前指定@RequestParam绑定的参数
     *@RequestParam还可以指定默认值，也可以指定这个参数是必须要提供的，如果不提供，就报错，
     */
    public String test2(@RequestParam(value = "tt") String name, String pwd){
        return name+"-------------"+pwd;
    }

    @GetMapping("/test3/{name}/{pwd}")
    /**
     * 可以直接从url中获取name pwd的属性值。这是一种testful风格的参数。
     */
    public String test3(@PathVariable  String name,@PathVariable  String pwd){
        return name+"-------------"+pwd;
    }

}
