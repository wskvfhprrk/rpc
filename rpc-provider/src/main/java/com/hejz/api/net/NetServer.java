package com.hejz.api.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务管理
 *
 * @author hejz
 * @version 1.0
 * @date 2021/1/15 14:12
 */
public class NetServer {

    //定义线程池数量
    static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    /**
     * 服务端启动
     *
     * @param port 启动端口
     */
    public static void serverUp(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        /**
         * Socket socket = serverSocket.accept();
         * 阻塞serverSocket客户端的连接。。一旦有客户端连接就可以获得一个socket对象，但服务端可能有多用户调用，
         * 如果Blocking IO方式还会阻塞工程线程，仅在主线程使用，采用BIO方式效率非常低，应使用多线程（线程池方式）处理对象
         * 如果使用简单线程浪费，线程开销非常浪费资源，应该使用线程池
         */
        while (true) {
            System.out.println("接收到socket");
            Socket socket = serverSocket.accept();//进行阻塞等待
            //用一个线程来处理socket对象，如果没有线程就等待
            executorService.submit(new RPCProcessor(socket));
        }
    }

    public static void main(String[] args) throws IOException {
        serverUp(9999);
        System.out.println("socket服务启动");
    }
}
