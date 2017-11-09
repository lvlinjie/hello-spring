package com.spdb.lvlj.doamin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity(name = "DemoInfo") //这里，制定的是数据库中哪一个表，如果没有这个表，jpa会帮我们创建一下
public class DemoInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id   //指定数据的id和主键策略
    @GeneratedValue
    private long id;
    @Column(name = "name") //对应表中哪一个字段的名称
    private String name;
    @Column(name = "pwd")
    private String pwd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "DemoInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
