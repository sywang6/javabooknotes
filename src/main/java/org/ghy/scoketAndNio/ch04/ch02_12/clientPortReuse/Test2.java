package org.ghy.scoketAndNio.ch04.ch02_12.clientPortReuse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Thread server = new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket();
                   serverSocket.setReuseAddress(true);
                    serverSocket.bind(new InetSocketAddress("172.16.16.148",8889));
                    Socket socket = serverSocket.accept();
                    Thread.sleep(3000);
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        server.start();
        Thread.sleep(500);
        Thread client = new Thread(){
            @Override
            public void run() {
                try {
                    Socket socket = new Socket();
                    //允许端口复用
                    socket.setReuseAddress(false);
                    //连续两次运行,socket可以绑定到7777(在Linux系统?我没有验证)
                    socket.bind(new InetSocketAddress("172.16.16.148",7777));
                    socket.connect(new InetSocketAddress("172.16.16.148",8889));
                    System.out.println("socket.getLocalPort " +socket.getLocalPort());
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        client.start();
    }
}
