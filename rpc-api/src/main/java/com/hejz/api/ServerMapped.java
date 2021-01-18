package com.hejz.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义接口实现类
 * @author hejz
 * @version 1.0
 * @date 2021/1/18 12:01
 */
@Target(ElementType.TYPE)
//生命周期
@Retention(RetentionPolicy.RUNTIME)
public @interface ServerMapped {
    String value();
}
