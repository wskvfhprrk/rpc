package com.hejz;

import com.hejz.api.UserService;
import com.hejz.dto.UserDto;
import com.hejz.proxy.FactoryProxy;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/18 9:13
 */
public class UserTest {
    public static void main(String[] args) {
        UserService userService = FactoryProxy.getInstanceByClassType(UserService.class);
        UserDto userDto = new UserDto();
        userDto.setName("张三");
        userDto.setAge(18);
        System.out.println("调用前：" + userDto);
        userDto = userService.addUser(userDto);
        System.out.println("调用后：" + userDto);
    }
}
