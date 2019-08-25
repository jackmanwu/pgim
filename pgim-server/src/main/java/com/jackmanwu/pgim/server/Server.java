package com.jackmanwu.pgim.server;

import com.jackmanwu.pgim.server.config.ZkConfig;
import com.jackmanwu.pgim.server.config.ZkProperties;
import com.jackmanwu.pgim.server.zk.ZkRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

/**
 * Created by JackManWu on 2019/8/24.
 */
@Slf4j
@SpringBootApplication
public class Server implements CommandLineRunner {
    @Autowired
    private ZkConfig zkConfig;

    @Autowired
    private ZkProperties zkProperties;

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);

        log.info("pgim 服务端启动完成...");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("加载数据...");
        String address = InetAddress.getLocalHost().getHostAddress();
        log.info("当前IP：{}", address);
        Thread zkRegistryThread = new Thread(new ZkRegistry(zkConfig, zkProperties, address));
        zkRegistryThread.setName("zk-registry");
        zkRegistryThread.start();
    }
}