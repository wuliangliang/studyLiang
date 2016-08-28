package com.liang.nwtwork.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liang on 16/5/25.
 */
public class test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        InetAddress inetAddress1 = InetAddress.getLocalHost();

        String host = inetAddress1.getHostAddress();
        String ip = inetAddress1.getHostName();
        System.out.println(host+"ff"+ip);
    }
}
