package com.liang.nwtwork.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liang on 16/5/25.
 */
public class SimpleSocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket =null;
        InputStream in  = null;
        OutputStream out  = null;
        int port =10000;
        try{
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            in = socket.getInputStream();
            byte[] b = new byte[1024];
            for(int i = 0;i<3;i++)
            {
                int n = in.read(b);
                //输出
                System.out.println("客户端发送内容为：" + new String(b,0,n));
                //向客户端发送反馈内容
                out = socket.getOutputStream();
                out.write(b, 0, n);
            }

        }catch (Exception e) {

        }finally{
            try{
                //关闭流和连接
                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            }catch(Exception e){}
        }


    }
}
