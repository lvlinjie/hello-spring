package com.spdb.lvlj.doamin.controller;

import com.spdb.lvlj.doamin.dao.BookDao;
import com.spdb.lvlj.doamin.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Book控制类
 * @author user
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDao bookDao;

    /**
     * 查询所有图书
     * @return
     */
    @RequestMapping(value="/list")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("bookList", bookDao.findAll());
        mav.setViewName("bookList");
        return mav;
    }



    /**
     * 添加图书
     * @param book
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String add(Book book){
        bookDao.save(book);
        return "forward:/book/list";
    }

    @GetMapping(value="/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Integer id){
        ModelAndView mav=new ModelAndView();
        mav.addObject("book", bookDao.getOne(id));
        mav.setViewName("bookUpdate");
        return mav;
    }

    /**
     * 修改图书
     * @param book
     * @return
     */
    @PostMapping(value="/update")
    public String update(Book book){
        bookDao.save(book);
        return "forward:/book/list";
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method= RequestMethod.GET)
    public String delete(Integer id){
        bookDao.delete(id);
        return "forward:/book/list";
    }


    /**
     * 录入图书信息
     *
     */
    @RequestMapping(value="/toadd",method= RequestMethod.GET)
    public ModelAndView toAdd(){
    ModelAndView modelAndView  = new ModelAndView();
    modelAndView.setViewName("bookAdd");
        System.out.println("111111");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/queryByName")
    public List<Book> findByName(){
        return  bookDao.findByName("p");
    }

    @ResponseBody
    @GetMapping("/rand")
    public List<Book> findByRand(){
        return  bookDao.randomList(2);
    }


}
