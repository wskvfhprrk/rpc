package com.hejz.api.dispatch;

import com.hejz.dto.RPCCommonReqDto;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务处理分发方法
 *
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:38
 */
public class ServiceDispatch {
    /**
     * 服务分发
     * @param reqObject
     * @return
     */
    public static Object dispatch(Object reqObject) {
        RPCCommonReqDto rpcCommonReqDto=(RPCCommonReqDto)reqObject;
        String methodName = rpcCommonReqDto.getMethodName();
        String classPath = rpcCommonReqDto.getClassPath();
        Object[] args = rpcCommonReqDto.getArgs();
        List<Class> types=new ArrayList<>();
        for (Object arg : args) {
            types.add(arg.getClass());
        }
        //todo 是否要判断空值——测试的时候再入说
        Class[] classes = types.toArray(new Class[args.length]);
        Object resObject=null;
        //反射方法调用
        try {
            Class<?> aClass = Class.forName(classPath);
            Method method = aClass.getDeclaredMethod(methodName, classes);
            //调用invoke方法后把返回值返回
            resObject = method.invoke(aClass.newInstance(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resObject;
    }
}
