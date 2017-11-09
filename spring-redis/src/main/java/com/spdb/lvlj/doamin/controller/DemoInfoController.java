package com.spdb.lvlj.doamin.controller;


import com.spdb.lvlj.doamin.pojo.DemoInfo;
import com.spdb.lvlj.doamin.service.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoInfoController {

    @Autowired
    DemoInfoService demoInfoService;
    @GetMapping("/test")
    public String test(){
        DemoInfo loaded = demoInfoService.findById(1);
        System.out.println("loaded="+loaded);
        DemoInfo cached = demoInfoService.findById(1);
        System.out.println("cached="+cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2="+loaded);
        return"ok";
    }

    @GetMapping("/delete")
    public String delete(long id){
        demoInfoService.deleteFromCache(id);
        return"ok";
    }
    @GetMapping("/test1")
    public String test1(){
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return"ok";
    }


}
