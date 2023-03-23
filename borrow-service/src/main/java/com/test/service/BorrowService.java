package com.test.service;

import com.test.entity.UserBorrowDetail;

/**
 * @author Liao
 */
public interface BorrowService {

    /**
     * 根据用户id查询借阅明细信息
     * @param uid
     * @return
     */
    UserBorrowDetail getUserBorrowDetailByUid(int uid);
}
