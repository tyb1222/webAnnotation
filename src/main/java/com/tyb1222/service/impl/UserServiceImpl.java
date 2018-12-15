package com.tyb1222.service.impl;

import com.tyb1222.anno.UserAnno;
import com.tyb1222.dao.UserDao;
import com.tyb1222.service.CacheService;
import com.tyb1222.service.LogService;
import com.tyb1222.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@UserAnno(key = "class-key",cacheName ="USER_INFO",needLog = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    private final static String CACHE_KEY = "USER_INFO";

    @UserAnno(key = "#userId",cacheName =CACHE_KEY,needLog = true)
    public String getUserName(String userId) {

        String userName = userDao.getUserName(userId);

        return userName;
    }
}
