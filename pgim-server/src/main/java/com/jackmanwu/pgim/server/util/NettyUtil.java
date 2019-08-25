package com.jackmanwu.pgim.server.util;

import io.netty.buffer.ByteBuf;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Created by JackManWu on 2019/8/25.
 */
public class NettyUtil {
    public static Object byteToObject(byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    public static byte[] objectToByte(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            bytes = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }

    public static byte[] byteBufToByte(ByteBuf byteBuf) {
        return byteBuf.array();
    }
}
