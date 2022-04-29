package com.zknet.gateway.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BizCodeEnum {
    NOT_AUTH(1106, "权限不足");
    /**
     * 业务码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String msg;
}
