package com.xusheng.config;

import com.xusheng.common.AbstractConfig;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:18
 * @Desc
 */
public class ServiceConfig<T> extends AbstractConfig {

    private Class<?> interfaceClass;

    protected T ref;

    public void setInterface(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public void export() {

    }
}
