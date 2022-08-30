package com.xusheng.common.scanner.server;

import com.xusheng.annotation.RpcService;
import com.xusheng.common.scanner.ClassScanner;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author xusheng
 * @Date 2022/8/30 19:09
 * @Desc
 */
public class RpcServiceScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServiceScanner.class);

    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage) throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList(scanPackage);
        if (CollectionUtils.isEmpty(classNameList)) {
            return new HashMap<>();
        }
        Map<String, Object> resultMap = new HashMap<>();
        classNameList.forEach(className -> {
            try {
                Class<?> clazz = Class.forName(className);
                RpcService rpcService = clazz.getAnnotation(RpcService.class);
                if (Objects.isNull(rpcService)) {
                    return;
                }
                LOGGER.info("当前标注了@RpcService注解的类实例名称===>>> " + clazz.getName());
                LOGGER.info("@RpcService注解上标注的属性信息如下：");
                LOGGER.info("interfaceClass===>>> " + rpcService.interfaceClass().getName());
                LOGGER.info("interfaceClassName===>>> " + rpcService.interfaceClassName());
                LOGGER.info("version===>>> " + rpcService.version());
                LOGGER.info("group===>>> " + rpcService.group());
            } catch (Exception e) {
                LOGGER.error("scan classes throws exception:{}", e);
            }
        });
        return resultMap;
    }
}
