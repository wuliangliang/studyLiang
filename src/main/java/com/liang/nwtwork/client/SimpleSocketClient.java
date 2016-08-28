package com.liang.nwtwork.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by liang on 16/5/25.
 */
public class SimpleSocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        String serverIp = "127.0.0.1";
        int port = 10000;
        String[] data = {"hello","nihao","你好"};
        try{
            socket = new Socket(serverIp,port);
            out = socket.getOutputStream();
            for(int i = 0 ;i<3;i++) {
                out.write(data[i].getBytes());

                in = socket.getInputStream();
                byte[] b = new byte[1024];
                int n = in.read(b);
                //输出反馈数据
                System.out.println("服务器反馈：" + new String(b, 0, n));
            }
        }catch (Exception e){

        }finally{
            try {
                //关闭流和连接
                in.close();
                out.close();
                socket.close();
            } catch (Exception e2) {}
        }
    }
}
