package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserDao;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(int userId) {
        return userDao.selectById(userId);
    }
}
