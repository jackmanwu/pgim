package com.jackmanwu.pgim.server.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;

    private String message;

    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
