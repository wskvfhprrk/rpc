package com.hejz.api.net;

import com.hejz.api.dispatch.ServiceDispatch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:28
 */
public class RPCProcessor implements Runnable {
    private Socket socket;

    public RPCProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //处理sokcet对象
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //把socket获得的输入输出流包装为Object的输入输出流
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //从网络中获取到的对象
            Object readObject = objectInputStream.readObject();
            //获取处理结果得到返回值
            Object resObject = ServiceDispatch.dispatch(readObject);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //把处理到结果通过返回值返回
            objectOutputStream.writeObject(resObject);
            //清空
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
