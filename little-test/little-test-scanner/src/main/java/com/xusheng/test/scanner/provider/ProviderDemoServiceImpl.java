package com.xusheng.test.scanner.provider;

import com.xusheng.annotation.RpcService;
import com.xusheng.test.scanner.service.DemoService;

/**
 * @Author xusheng
 * @Date 2022/8/30 15:38
 * @Desc
 */
@RpcService(interfaceClass = DemoService.class, interfaceClassName = "com.xusheng.test.scanner.service.DemoService", version = "1.0.0", group = "ttt")
public class ProviderDemoServiceImpl implements DemoService{
}
