package com.hejz.proxy;


import java.io.Serializable;
import java.lang.reflect.Proxy;

/**
 * 动态实现类接口
 * @author hejz
 * @version 1.0
 * @date 2021/1/18 9:20
 */
public class FactoryProxy {
    /**
     * 动态代理查询接口实现类——根据接口类型获取动态实现类
     * @param interfaceClazz
     * @param <T>
     * @return
     */
    public static <T> T getInstanceByClassType(Class<T> interfaceClazz) {

        return (T) Proxy.newProxyInstance(FactoryProxy.class.getClassLoader(),
                new Class[]{
                        interfaceClazz, Serializable.class
                },new RPCInvokationHandler());
    }
}
