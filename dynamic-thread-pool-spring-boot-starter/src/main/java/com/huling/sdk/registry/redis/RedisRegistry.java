package com.huling.sdk.registry.redis;

import com.huling.sdk.domain.model.entity.ThreadPoolConfigEntity;
import com.huling.sdk.domain.model.valobj.RegistryEnumVO;
import com.huling.sdk.registry.IRegistry;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.List;

/**
 * @author huling
 * @description Redis注册中心
 * @date 2025/3/10 10:41:42
 */
public class RedisRegistry implements IRegistry {

    private final RedissonClient redissonClient;

    public RedisRegistry(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolEntities) {
        // TODO:线程池配置列表的Key设计：TPConfig:AppName:Host
        RList<ThreadPoolConfigEntity> list = redissonClient.getList(RegistryEnumVO.THREAD_POOL_CONFIG_LIST_KEY.getKey());
        list.delete();
        list.addAll(threadPoolEntities);
    }

    @Override
    public void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity) {
        // TODO:线程池配置的Key设计：TPConfig:AppName:Host:ThreadPoolName
        String cacheKey = RegistryEnumVO.THREAD_POOL_CONFIG_PARAMETER_KEY.getKey() + "_" + threadPoolConfigEntity.getAppName() + "_" + threadPoolConfigEntity.getThreadPoolName();
        RBucket<ThreadPoolConfigEntity> bucket = redissonClient.getBucket(cacheKey);
        bucket.set(threadPoolConfigEntity, Duration.ofDays(30));
    }
}
