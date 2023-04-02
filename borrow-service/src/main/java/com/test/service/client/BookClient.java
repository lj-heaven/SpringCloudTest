package com.test.service.client;

import com.test.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bookservice")
public interface BookClient {
    @RequestMapping("/book")
    public Book findBookById(@RequestParam int bid);
}
