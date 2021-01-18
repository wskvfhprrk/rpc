package com.hejz.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端docket调用
 * @author hejz
 * @version 1.0
 * @date 2021/1/18 10:32
 */
public class NetClient {
    public static Object callRemotService(String host, int port, Object reqObject) {
        //处理sokcet对象
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Object resObject = null;
        try {
            Socket socket = new Socket(host, port);
            //流的处理
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //把处理到结果通过返回值返回
            objectOutputStream.writeObject(reqObject);
            //清空
            objectOutputStream.flush();

            //把socket获得的输入输出流包装为Object的输入输出流
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //从网络中获取到的对象
            resObject = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resObject;
    }
}
