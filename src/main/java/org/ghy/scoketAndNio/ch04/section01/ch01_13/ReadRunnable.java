package org.ghy.scoketAndNio.ch04.section01.ch01_13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadRunnable implements  Runnable{
    private Socket socket;

    public ReadRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1000];
            int readLength = -1;
            while ((readLength = inputStreamReader.read(charArray)) != -1){
                String newString = new String(charArray,0,readLength);
                System.out.println(newString);
            }
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
