package com.test.service;


import com.test.entity.Book;

/**
 * @author Liao
 */
public interface BookService {

    /**
     * 根据书籍id查询书籍信息
     * @param bid
     * @return Book
     */
    Book getBookById(int bid);
}
