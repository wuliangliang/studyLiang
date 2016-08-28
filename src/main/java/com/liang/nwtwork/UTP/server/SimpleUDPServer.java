package com.liang.nwtwork.UTP.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by liang on 16/5/26.
 */
public class SimpleUDPServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket= null;
        DatagramPacket send;
        DatagramPacket recive;
        final int port = 10001;
        try{
            datagramSocket = new DatagramSocket(port);
            System.out.println("网络连接成功");
            byte[] bytes = new byte[1024];
            recive = new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(recive);

            InetAddress clientIP = recive.getAddress();

            int clientPort = recive.getPort();

            for(int i = 0 ;i<100;i++) {
                byte[] data = recive.getData();

                int len = recive.getLength();

                System.out.println("客户端IP：" + clientIP.getHostAddress());

                System.out.println("客户端端口：" + clientPort);

                System.out.println("客户端发送内容：" + new String(data, 0, len));
                Thread.sleep(10);
                //发送反馈

                String response = "OK";

                byte[] bData = response.getBytes();

                send = new DatagramPacket(bData, bData.length, clientIP, clientPort);

                //发送

                datagramSocket.send(send);
            }

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                //关闭连接

                datagramSocket.close();

            }catch(Exception e){}

        }
    }
}
