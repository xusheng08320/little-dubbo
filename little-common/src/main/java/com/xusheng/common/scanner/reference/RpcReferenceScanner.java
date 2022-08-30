package com.xusheng.common.scanner.reference;

import com.xusheng.annotation.RpcReference;
import com.xusheng.common.scanner.ClassScanner;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author xusheng
 * @Date 2022/8/30 19:26
 * @Desc
 */
public class RpcReferenceScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcReferenceScanner.class);

    public static Map<String, Object> doScannerWithRpcReferenceAnnotationFilter(String scanPackage) throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList(scanPackage);
        if (CollectionUtils.isEmpty(classNameList)) {
            return new HashMap<>();
        }
        Map<String, Object> resultMap = new HashMap<>();
        classNameList.forEach(className -> {
            try {
                Class<?> clazz = Class.forName(className);
                Field[] declaredFields = clazz.getDeclaredFields();
                Stream.of(declaredFields).forEach(field -> {
                    RpcReference rpcReference = field.getAnnotation(RpcReference.class);
                    if (Objects.isNull(rpcReference)) {
                        return;
                    }
                    LOGGER.info("当前标注了@RpcReference注解的字段名称===>>> " + field.getName());
                    LOGGER.info("@RpcReference注解上标注的属性信息如下：");
                    LOGGER.info("version===>>> " + rpcReference.version());
                    LOGGER.info("group===>>> " + rpcReference.group());
                    LOGGER.info("registryType===>>> " + rpcReference.registryType());
                    LOGGER.info("registryAddress===>>> " + rpcReference.registryAddress());
                });
            } catch (Exception e) {
                LOGGER.error("scan classes throws exception:{}", e);
            }
        });
        return resultMap;
    }

}
