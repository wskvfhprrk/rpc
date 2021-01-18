package com.hejz.api.Impl;

import com.hejz.api.UserService;
import com.hejz.dto.UserDto;

import java.util.UUID;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:05
 */
public class UserServerImpl implements UserService {
    @Override
    public UserDto addUser(UserDto userDto) {
        System.out.println("接收到："+userDto);
        //具体的业务逻辑，现模拟添加数据库后给一个userId,然后把值再返回过去
        userDto.setUserId(UUID.randomUUID().toString());
        System.out.println("返回："+userDto);
        return userDto;
    }
}
