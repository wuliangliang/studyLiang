package com.liang.nwtwork.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by liang on 16/5/25.ll;
 *
 */
public class LogicThread extends Thread{
    Socket socket = null;
    InputStream is = null;
    OutputStream os =null;
    LogicThread (Socket socket)
    {
        this.socket = socket;
        start();
    }
    public void run() {
        byte[] b = new byte[1024];
        try {
            //初始化流
            os = socket.getOutputStream();
            is = socket.getInputStream();
            for (int i = 0; i < 3; i++) {
                //读取数据
                int n = is.read(b);
                //逻辑处理
                byte[] response = logic(b, 0, n);
                //反馈数据
                os.write(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private void close(){
        try{
            //关闭流和连接
            os.close();
            is.close();
            socket.close();
        }catch(Exception e){}
    }


    private byte[] logic(byte[] b,int off,int len){
        byte[] response = new byte[len];
        //将有效数据拷贝到数组response中
        System.arraycopy(b, 0, response, 0, len);
        return response;
    }
}
