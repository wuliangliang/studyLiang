package com.liang.nwtwork.UTP.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * Created by liang on 16/5/26.
 */
public class MulUDPServer {
    public static void main(String[] args) {
        DatagramSocket ds = null; //连接对象
        DatagramPacket receiveDp; //接收数据包对象
        final int PORT = 10012; //端口
        byte[] b = new byte[1024];
        receiveDp = new DatagramPacket(b,b.length);
        try{
//建立连接，监听端口
            ds = new DatagramSocket(PORT);
            System.out.println("服务器端已启动：");
            while(true){
//接收
                ds.receive(receiveDp);
//启动线程处理数据包
                new LogicThread(receiveDp,ds);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
//关闭连接
                ds.close();
            }catch(Exception e){}
        }
    }
}
