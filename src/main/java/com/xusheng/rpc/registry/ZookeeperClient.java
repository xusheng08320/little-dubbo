package com.xusheng.rpc.registry;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author xusheng
 * @Date 2022/6/27 20:58
 * @Desc
 */
public class ZookeeperClient {

    private CuratorFramework client;

    public ZookeeperClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();
    }

    public void create(String path, boolean ephemeral) {
        try {
            client.create().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
