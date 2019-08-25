package com.jackmanwu.pgim.server.netty;

import com.jackmanwu.pgim.server.netty.protocol.MsgDecoder;
import com.jackmanwu.pgim.server.netty.protocol.MsgEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Slf4j
@Component
public class NettyServer {
    @Value("${spring.netty.port}")
    private int nettyPort;

    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    @PostConstruct
    public void initNetty() {
        log.info("netty服务端启动中...");
        try {
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .localAddress(new InetSocketAddress(nettyPort))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new MsgDecoder());
                            ch.pipeline().addLast(new MsgEncoder());
                            ch.pipeline().addLast(new MyChannelInboundHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind().sync();
            if (future.isSuccess()) {
                log.info("netty启动成功...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        bossGroup.shutdownGracefully().syncUninterruptibly();
        workerGroup.shutdownGracefully().syncUninterruptibly();
        log.info("netty关闭成功...");
    }
}
