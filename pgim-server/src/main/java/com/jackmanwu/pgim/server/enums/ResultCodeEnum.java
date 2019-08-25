package com.jackmanwu.pgim.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private int code;

    private String desc;
}