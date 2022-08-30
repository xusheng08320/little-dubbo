package com.xusheng.test.scanner.consumer.impl;

import com.xusheng.annotation.RpcReference;
import com.xusheng.test.scanner.consumer.ConsumerBusinessService;
import com.xusheng.test.scanner.service.DemoService;

/**
 * @Author xusheng
 * @Date 2022/8/30 15:40
 * @Desc
 */
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

    @RpcReference(registryType = "zookeeper", registryAddress = "127.0.0.1:2181", version = "1.0.0", group = "ttt")
    private DemoService demoService;
}
