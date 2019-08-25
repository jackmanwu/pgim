package com.jackmanwu.pgim.server.config;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JackManWu on 2019/8/24.
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(ZkProperties.class)
public class ZkConfig {
    @Autowired
    private ZkProperties zkProperties;

    @Autowired
    private ZkClient zkClient;

    @Bean("zkClient")
    public ZkClient createZkClient() {
        return new ZkClient(zkProperties.getZkAddress(), zkProperties.getZkConnectTimeOut());
    }

    /**
     * 创建父节点
     */
    public void createRootNode() {
        if (zkClient.exists(zkProperties.getZkRoot())) {
            log.info("zk根节点【{}】已经存在", zkProperties.getZkRoot());
            return;
        }
        zkClient.createPersistent(zkProperties.getZkRoot());
    }

    /**
     * 创建临时节点
     *
     * @param path
     */
    public void createNode(String path) {
        log.info("临时节点路径：{}", path);
        if (zkClient.exists(path)) {
            zkClient.delete(path);
        }
        zkClient.createEphemeral(path);
    }
}
