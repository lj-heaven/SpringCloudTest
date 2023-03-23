package com.test.service.impl;


import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liao
 */
@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8101/user/"+uid,User.class);
        List<Book> books = borrows.stream()
                .map(borrow -> restTemplate.getForObject("http://localhost:8201/book?bid="+ borrow.getBid(),Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,books);
    }
}
