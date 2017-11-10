package com.spdb.lvlj.doamin.dao;

import com.spdb.lvlj.doamin.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    /**
     * from Book  不是从表中查询 ，是从Book实体中查询 ，所以这里要写成Book实体
     * b.bookName 这里也不是数据库应该对应的字段，对应的是实体的属性名称。
     * ？1  这里指的是第一个参数。和方法里面传进来的参数位置要保持同步
     * 这中执行hql查询语句
     * @param name
     * @return
     */

    @Query("select b from Book b where b.bookName like %?1%")
    public List<Book> findByName(String name);

    /**
     * 这个是执行本地查询，也就是用sql语句去查询数据库
     * @param n
     * @return
     */
    @Query(value = "select * from t_book order by RAND() limit ?1",nativeQuery = true)
    public List<Book> randomList(Integer n);


}
