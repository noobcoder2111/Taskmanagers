package com.marktech.taskmanager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {

    private final CacheManager cacheManager;

    @Autowired
    public CacheUtil(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void putInCache(String cacheName, String key, Object value) {
        var cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.put(key, value);
        }
    }

    public Object getFromCache(String cacheName, String key) {
        var cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            var cachedValue = cache.get(key);
            return cachedValue != null ? cachedValue.get() : null;
        }
        return null;
    }

    public void evictFromCache(String cacheName, String key) {
        var cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.evict(key);
        }
    }
}