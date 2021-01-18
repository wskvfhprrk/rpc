package com.hejz.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:06
 */
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -4782277824298987700L;
    private String name;
    private Integer age;
    private String userId;
}
