package com.hejz.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一请求标准
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 17:08
 */
@Data
public class RPCCommonReqDto implements Serializable {
    private static final long serialVersionUID = -6911831217463359343L;
    /**
     * 方法名RPCCommonReqDto
     */
    private String methodName;
    /**
     * 类全路径
     */
    private String classPath;
    /**
     * 所有参数列表
     */
    private Object[] args;
}
