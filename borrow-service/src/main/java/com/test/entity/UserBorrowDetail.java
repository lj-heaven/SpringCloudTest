package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 借阅明细实体类
 * @author Liao
 */
@Data
@AllArgsConstructor
public class UserBorrowDetail {

    User user;

    List<Book> bookList;
}
