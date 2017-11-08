package com.spdb.lvlj.controller;

import com.spdb.lvlj.propertises.BlogProperties;
import com.spdb.lvlj.propertises.HxlPerpertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PropertisesController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private HxlPerpertise hxlPerpertise;


    @RequestMapping("/get")
    public String get() {
        return blogProperties.getName() + "    " + blogProperties.getTitle() + " " + blogProperties.getDesc();
    }

    @RequestMapping("/post")
    public String post() {
        return  hxlPerpertise.getValue()+"_-->"+hxlPerpertise.getBignumber()+"-->"+hxlPerpertise.getNumber()+"-->"+hxlPerpertise.getTest1()+"-->"+hxlPerpertise.getTest2();
    }
}
