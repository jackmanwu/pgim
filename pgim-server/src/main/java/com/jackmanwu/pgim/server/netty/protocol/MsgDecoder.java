package com.jackmanwu.pgim.server.netty.protocol;

import com.jackmanwu.pgim.server.util.NettyUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by JackManWu on 2019/8/25.
 */
public class MsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(NettyUtil.byteToObject(NettyUtil.byteBufToByte(in)));
    }
}
