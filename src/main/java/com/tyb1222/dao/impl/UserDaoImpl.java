package com.tyb1222.dao.impl;

import com.tyb1222.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public String getUserName(String id) {
        return "zhangshan";
    }
}
