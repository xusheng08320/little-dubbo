package com.xusheng.rpc.registry;

import com.google.common.collect.Maps;
import com.xusheng.common.url.URL;

import java.util.Map;
import java.util.Objects;

/**
 * @Author xusheng
 * @Date 2022/6/27 20:40
 * @Desc
 */
public class RegistryFactory {

    private Map<String, Registry> cachedRegistry = Maps.newConcurrentMap();

    Registry getRegistry(URL url) {
        Registry registry = cachedRegistry.get(url.getProtocol());
        if (Objects.nonNull(registry)) {
            return registry;
        }
        if ("zookeeper".equals(url.getProtocol())) {
            return new ZooKeeperRegistry();
        }
        return null;
    }

}
