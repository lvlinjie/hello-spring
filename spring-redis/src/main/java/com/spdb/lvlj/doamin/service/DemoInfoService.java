package com.spdb.lvlj.doamin.service;

import com.spdb.lvlj.doamin.pojo.DemoInfo;

public interface DemoInfoService {

    public DemoInfo findById(long id);

    public void deleteFromCache(long id);

    void test();
}
