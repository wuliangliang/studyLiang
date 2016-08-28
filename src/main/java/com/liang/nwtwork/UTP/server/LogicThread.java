package com.liang.nwtwork.UTP.server;

import clojure.lang.IFn;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by liang on 16/5/26.
 */
public class LogicThread extends Thread{
    DatagramPacket datagramPacket ;
    DatagramSocket datagramSocket;
    public LogicThread(DatagramPacket datagramPacket,DatagramSocket datagramSocket)
    {
        this.datagramPacket = datagramPacket;
        this.datagramSocket = datagramSocket;
        start();
    }
    public void run()
    {
        //获得缓冲数组
        byte[] data = datagramPacket.getData();
//获得有效数据长度
        int len = datagramPacket.getLength();
//客户端IP
        InetAddress clientAddress =datagramPacket.getAddress();
//客户端端口
        int clientPort = datagramPacket.getPort();
//输出
        System.out.println("客户端IP：" + clientAddress.getHostAddress());
        System.out.println("客户端端口号：" + clientPort);
        System.out.println("客户端发送内容：" + new String(data,0,len));


        byte[] b = "OK".getBytes();
        DatagramPacket sendDp = new DatagramPacket(b,b.length,clientAddress,clientPort);
//发送
        try {
            datagramSocket.send(sendDp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
