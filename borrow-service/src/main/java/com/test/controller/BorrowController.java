package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * 借阅信息服务
 * @author Liao
 */
@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    //使用HystrixCommand指定备选方案
    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrow(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }

    //备选方案，这里直接返回空列表
    //注意参数和返回值要和上面一样
    UserBorrowDetail onError(int uid){
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}
