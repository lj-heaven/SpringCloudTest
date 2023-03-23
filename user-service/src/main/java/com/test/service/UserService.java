package com.test.service;

import com.test.entity.User;

/**
 * @author Liao
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param uid
     * @return User
     */
    User getUserById(int uid);
}
