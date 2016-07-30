package com.lei.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by com.lei on 15-8-13.
 */
public class LocalCache {
    // singleton.
    private static Cache<String, byte[]> cache = null;
    private static LocalCache instance = null;

    public static void init(Long expireSecond, Long maxCapacity) {
        instance = new LocalCache(expireSecond, maxCapacity);
    }

    public static void init() {
        init(3600l, 64 * 1024 * 1024l);
    }

    private LocalCache(Long expireSecond, Long maxCapacity) {
        CacheBuilder builder = CacheBuilder.newBuilder();
        builder.expireAfterWrite(expireSecond, TimeUnit.SECONDS);
        builder.maximumSize(maxCapacity);
        cache = builder.build();
    }

    public static LocalCache getInstance() {
        return instance;
    }

    public byte[] get(String k) {
        return cache.getIfPresent(k);
    }

    public void set(String k, byte[] b) {
        cache.put(k, b);
    }

    public void clear() {
        cache.invalidateAll();
    }

}