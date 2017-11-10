package com.spdb.lvlj.doamin.dao;

import com.spdb.lvlj.doamin.pojo.DemoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/*
*这是一个接口，没有具体的实现，这就是JPA,只要继承了这一个接口，就不用再写sql语句
*JpaRepository<DemoInfo,Long>，第一个是pojo，第二个是这个Pojo的铸件类型
*/
public interface DemoInfoRepository extends JpaRepository<DemoInfo,Long> {


}
