package com.spdb.lvlj.propertises;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 配置文件类，必须要被扫描
 */
@Component
public class BlogProperties {
    // @Value(“${属性名}”)就可能以读取到配置信息。
    @Value("${com.spdb.lvlj.name}")
    private String name;
    @Value("${com.spdb.lvlj.title}")
    private String title;
    @Value("${com.spdb.lvlj.desc}")
    private String desc;
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
