package com.jackmanwu.pgim.server.netty.protocol;

import com.jackmanwu.pgim.server.util.NettyUtil;
import com.jackmanwu.pgim.server.vo.MsgVo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by JackManWu on 2019/8/25.
 */
public class MsgEncoder extends MessageToByteEncoder<MsgVo> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MsgVo msg, ByteBuf out) throws Exception {
        byte[] bytes = NettyUtil.objectToByte(msg);
        out.writeBytes(bytes);
        ctx.flush();
    }
}
