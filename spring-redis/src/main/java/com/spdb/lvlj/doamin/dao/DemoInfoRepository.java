package com.spdb.lvlj.doamin.dao;

import com.spdb.lvlj.doamin.pojo.DemoInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DemoInfoRepository extends JpaRepository<DemoInfo,Long> {

}
