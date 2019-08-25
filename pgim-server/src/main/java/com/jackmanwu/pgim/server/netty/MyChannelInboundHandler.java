package com.jackmanwu.pgim.server.netty;

import com.jackmanwu.pgim.server.util.SessionCache;
import com.jackmanwu.pgim.server.vo.MsgVo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Slf4j
@ChannelHandler.Sharable
public class MyChannelInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MsgVo msgVo = (MsgVo) msg;
        log.info("当前消息体：{}", msgVo.toString());
        SessionCache.putChannel(msgVo.getUserId(), (NioSocketChannel) ctx.channel());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
