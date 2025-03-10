package com.huling.sdk.domain;

import com.huling.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author huling
 * @description 动态线程池服务
 * @date 2025/3/10 09:54:02
 */
public interface IDynamicThreadPoolService {

    List<ThreadPoolConfigEntity> queryThreadPoolList();

    ThreadPoolConfigEntity queryThreadPoolConfigByName(String threadPoolName);

    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);

}
