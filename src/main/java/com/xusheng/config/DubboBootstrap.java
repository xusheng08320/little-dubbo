package com.xusheng.config;

import com.xusheng.common.application.ApplicationConfig;
import com.xusheng.common.registry.RegistryConfig;
import lombok.Builder;
import lombok.Data;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:23
 * @Desc
 */
@Builder
@Data
public class DubboBootstrap {

    private ApplicationConfig applicationConfig;

    private RegistryConfig registryConfig;

    private ServiceConfig serviceConfig;

    public void start() {
        init();

    }

    private void init() {

    }
}
