package com.xusheng.common.manager;

import com.xusheng.config.ServiceConfig;
import lombok.Data;

import java.util.Map;

/**
 * @Author xusheng
 * @Date 2022/6/23 19:34
 * @Desc
 */
@Data
public class ConfigManager {

    private Map<String, ServiceConfig> serviceConfigs;
}
