package com.jackmanwu.pgim.server.service;

import com.jackmanwu.pgim.server.util.SessionCache;
import com.jackmanwu.pgim.server.vo.MsgVo;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Slf4j
@Service
public class MsgService {
    public void sendMsg(MsgVo msgVo) {
        NioSocketChannel channel = SessionCache.getChannel(msgVo.getUserId());
        if (channel == null) {
            throw new NullPointerException("客户端【" + msgVo.getUserId() + "】不在线");
        }
        ChannelFuture future = channel.writeAndFlush(msgVo);
        future.addListener(ChannelFuture -> log.info("服务端发送消息成功：{}", msgVo.toString()));
    }
}