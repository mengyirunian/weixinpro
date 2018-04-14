package com.mengyirunian.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  应用上下文配置
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@Data
public class RootConfig {

    @Value(value = "${weixin.service.name}")
    private String serviceName;
    @Value(value = "${weixin.service.code}")
    private String serviceCode;

}
