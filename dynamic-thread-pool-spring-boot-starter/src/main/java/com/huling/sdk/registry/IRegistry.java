package com.huling.sdk.registry;

import com.huling.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author huling
 * @description 注册中心接口
 * @date 2025/3/10 10:14:07
 */
public interface IRegistry {

    void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolEntities);

    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);

}
