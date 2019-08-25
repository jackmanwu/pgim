package com.jackmanwu.pgim.server.zk;

import com.jackmanwu.pgim.server.config.ZkConfig;
import com.jackmanwu.pgim.server.config.ZkProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Slf4j
@AllArgsConstructor
public class ZkRegistry implements Runnable {
    private ZkConfig zkConfig;

    private ZkProperties zkProperties;

    private String ip;

    @Override
    public void run() {
        zkConfig.createRootNode();
        zkConfig.createNode(zkProperties.getZkRoot() + "/" + ip);
    }
}
