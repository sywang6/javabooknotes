package org.ghy.scoketAndNio.ch04.section01.ch01_09;

import java.io.IOException;
import java.net.ServerSocket;

//wireshark抓包,分析tcp三次握手的过程
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8088);
            System.out.println("server阻塞开始="+System.currentTimeMillis());
            socket.accept();
            System.out.println("server阻塞结束="+System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
