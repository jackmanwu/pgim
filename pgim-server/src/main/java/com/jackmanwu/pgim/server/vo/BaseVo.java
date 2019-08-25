package com.jackmanwu.pgim.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Data
public class BaseVo {
    @ApiModelProperty(required = false, value = "唯一请求号", example = "1")
    private String no;

    @ApiModelProperty(required = false, value = "当前时间戳", example = "0")
    private int timestamp;
}
