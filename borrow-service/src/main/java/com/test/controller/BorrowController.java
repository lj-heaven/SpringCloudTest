package com.test.controller;

import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 借阅信息服务
 * @author Liao
 */
@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrow(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}
