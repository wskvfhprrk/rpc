package com.hejz.api;

import com.hejz.dto.UserDto;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:06
 */
@ServerMapped("com.hejz.api.Impl.UserServerImpl")
public interface UserService {
    UserDto addUser(UserDto userDto);
}
