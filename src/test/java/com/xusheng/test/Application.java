package com.xusheng.test;

import com.xusheng.common.application.ApplicationConfig;
import com.xusheng.common.registry.RegistryConfig;
import com.xusheng.config.DubboBootstrap;
import com.xusheng.config.ServiceConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:51
 * @Desc
 */
@Slf4j
public class Application {

    @Test
    public void testProviderStart() {
        ServiceConfig<DemoServiceimpl> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new DemoServiceimpl());

        ApplicationConfig applicationConfig = new ApplicationConfig("demo-test");
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");

        DubboBootstrap dubboBootstrap = DubboBootstrap.builder()
                .applicationConfig(applicationConfig)
                .registryConfig(registryConfig)
                .serviceConfig(serviceConfig)
                .build();
        dubboBootstrap.start();

    }
}
