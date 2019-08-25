package com.jackmanwu.pgim.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by JackManWu on 2019/8/24.
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.zk")
public class ZkProperties {
    private String zkRoot;

    private String zkAddress;

    private int zkConnectTimeOut;
}
