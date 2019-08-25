package com.jackmanwu.pgim.server.util;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JackManWu on 2019/8/25.
 */
public class SessionCache {
    private static final Map<Long, NioSocketChannel> CHANNEL_CACHE = new ConcurrentHashMap<>(16);

    private static final Map<Long, String> USER_CACHE = new ConcurrentHashMap<>(16);

    public static void putChannel(Long userId, NioSocketChannel channel) {
        CHANNEL_CACHE.put(userId, channel);
    }

    public static NioSocketChannel getChannel(Long userId) {
        return CHANNEL_CACHE.get(userId);
    }
}
