package com.xusheng.common.url;

import lombok.Data;

import java.util.Map;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:13
 * @Desc
 */
@Data
public class URL {

    private String protocol;

    private String host;

    private int port;

    private String path;

    private Map<String, String> parameters;
}
