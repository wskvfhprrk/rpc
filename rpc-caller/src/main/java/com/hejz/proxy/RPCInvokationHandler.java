package com.hejz.proxy;

import com.hejz.api.ServerMapped;
import com.hejz.dto.RPCCommonReqDto;
import com.hejz.net.NetClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/18 9:34
 */
public class RPCInvokationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装RPCCommReqDto，完成网络调用。
        RPCCommonReqDto rpcCommonReqDto=new RPCCommonReqDto();
        rpcCommonReqDto.setArgs(args);
        rpcCommonReqDto.setMethodName(method.getName());
        //此处不能写死，需要动态添加——使用注解方法动态获取
        String classPath = method.getDeclaringClass().getAnnotation(ServerMapped.class).value();
        rpcCommonReqDto.setClassPath(classPath);
        //完成网络调用
        Object resObject = NetClient.callRemotService("localhost", 9999, rpcCommonReqDto);
        return resObject;
    }
}
