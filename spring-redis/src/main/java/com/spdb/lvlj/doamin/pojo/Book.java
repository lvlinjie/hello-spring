package com.spdb.lvlj.doamin.pojo;


import javax.persistence.*;

@Entity
@Table(name="t_book")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length=100)
    private String bookName;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
