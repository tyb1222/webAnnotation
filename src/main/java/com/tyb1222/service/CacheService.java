package com.tyb1222.service;

public interface CacheService {
    Object get(String id,String cacheKey);

    void put(String id,Object object,String cacheKey);
}
