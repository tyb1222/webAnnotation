package com.tyb1222.service.impl;

import com.tyb1222.service.CacheService;
import org.springframework.stereotype.Service;

@Service(value = "cacheService")
public class CacheServiceImpl implements CacheService {
    public Object get(String id ,String cacheKey) {
        return null;
    }

    public void put(String id, Object object, String cacheKey) {
        System.out.println("put to cache success");
    }
}
