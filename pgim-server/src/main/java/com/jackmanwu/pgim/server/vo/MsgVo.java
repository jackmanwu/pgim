package com.jackmanwu.pgim.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Data
public class MsgVo extends BaseVo {
    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty(required = true, value = "用户ID", example = "1")
    private Long userId;

    @NotNull(message = "消息不能为空")
    @ApiModelProperty(required = true, value = "消息", example = "hello,jackmanwu")
    private String msg;
}
