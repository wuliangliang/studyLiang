package com.liang.nwtwork.UTP.client;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * Created by liang on 16/5/26.
 */
public class SimpleUDPClient {
    public static void main(String[] args) {
        DatagramSocket datagramSocket=null;
        DatagramPacket send;
        DatagramPacket recive;
        String host = "127.0.0.1";
        int port =10001;
        try{
            datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName(host);
            Date  date= new Date();
            byte[] data = date.toString().getBytes();
            send =new DatagramPacket(data,data.length,inetAddress,port);
            datagramSocket.send(send);

            byte[] reData = new byte[1024];
            recive = new DatagramPacket(reData,reData.length);
            datagramSocket.receive(recive);

            byte[] response = recive.getData();

            int len = recive.getLength();

            String s = new String(response,0,len);

            System.out.println("服务器端反馈为：" + s);
        }catch (Exception e) {

        }finally{

            try{

                //关闭连接

                datagramSocket.close();

            }catch(Exception e){}

        }
    }
}
