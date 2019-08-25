package com.jackmanwu.pgim.server.controller;

import com.jackmanwu.pgim.server.enums.ResultCodeEnum;
import com.jackmanwu.pgim.server.service.MsgService;
import com.jackmanwu.pgim.server.util.Result;
import com.jackmanwu.pgim.server.vo.MsgVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JackManWu on 2019/8/25.
 */
@Slf4j
@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;

    @ApiModelProperty("测试服务心跳")
    @GetMapping(value = "/ping")
    public void ping() {
        log.info("hello");
    }

    @ApiModelProperty("服务端发送消息")
    @PostMapping(value = "/msg")
    public Result sendMsg(MsgVo msgVo) {
        msgService.sendMsg(msgVo);
        return new Result(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
    }
}
