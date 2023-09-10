package com.kv.events.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Slf4j
public class RedisCacheErrorHdlr implements CacheErrorHandler {

    @Override
    public void handleCacheGetError(@NonNull RuntimeException exception, @NonNull Cache cache, @NonNull Object key) {
        log.error("Operation Failure: GET, Cache Name: {}, Key: {}, Exception Details: {} ",
                cache.getName(), key, ExceptionUtils.getRootCauseMessage(exception));
    }

    @Override
    public void handleCachePutError(@NonNull RuntimeException exception, @NonNull Cache cache, @NonNull Object key, @Nullable Object value) {
        log.error("Operation Failure: PUT, Cache Name: {}, Key: {}, Value: {} Exception Details: {} ",
                cache.getName(), key, value, ExceptionUtils.getRootCauseMessage(exception));
    }

    @Override
    public void handleCacheEvictError(@NonNull RuntimeException exception, @NonNull Cache cache, @NonNull Object key) {
        log.error("Operation Failure: EVICT, Cache Name: {}, Key: {}, Exception Details: {} ",
                cache.getName(), key, ExceptionUtils.getRootCauseMessage(exception));
    }

    @Override
    public void handleCacheClearError(@NonNull RuntimeException exception, @NonNull Cache cache) {
        log.error("Operation Failure: CLEAR, Cache Name: {}, Exception Details: {} ",
                cache.getName(), ExceptionUtils.getRootCauseMessage(exception));
    }
}
