package com.xusheng.test;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:52
 * @Desc
 */
public class DemoServiceimpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
