package com.xusheng.common.application;

import com.xusheng.common.AbstractConfig;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:26
 * @Desc
 */
@Data
@AllArgsConstructor
public class ApplicationConfig extends AbstractConfig {

    private String appName;
}
