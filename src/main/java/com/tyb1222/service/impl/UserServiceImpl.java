package com.tyb1222.service.impl;

import com.tyb1222.anno.UserAnno;
import com.tyb1222.dao.UserDao;
import com.tyb1222.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@UserAnno(cacheKey = "class-cacheKey",cacheName ="USER_INFO")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private final static String CACHE_KEY = "USER_INFO";

    @UserAnno(cacheKey = "#userId",cacheName =CACHE_KEY, loggable = true)
    public String getUserName(String userId) {

        return userDao.getUserName(userId);

    }
}
