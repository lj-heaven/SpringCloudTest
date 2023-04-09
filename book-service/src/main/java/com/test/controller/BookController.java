package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 书籍服务
 * @author Liao
 */
@RestController
public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/book")
    public Book findBookById(@RequestParam int bid,HttpServletRequest request){
        System.out.println(request.getHeader("Test"));
        return bookService.getBookById(bid);
    }
}
