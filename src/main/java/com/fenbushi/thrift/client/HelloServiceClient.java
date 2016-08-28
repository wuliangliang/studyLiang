//package com.fenbushi.thrift.client;
//
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//import org.apache.thrift.transport.TTransportException;
//import service.demo.Hello;
///**
// * Created by liang on 16/5/25.
// */
//public class HelloServiceClient {
//    public static void main(String[] args) {
//        try {
//            // 设置调用的服务地址为本地，端口为 7911
//            TTransport transport = new TSocket("localhost", 7911);
//            transport.open();
//            // 设置传输协议为 TBinaryProtocol
//            TProtocol protocol = new TBinaryProtocol(transport);
//            Hello.Client client = new Hello.Client(protocol);
//            // 调用服务的 helloVoid 方法
//            client.helloVoid();
//            transport.close();
//            String str=client.helloString("hello,Thrift");
//
//            System.out.println("resp:---"+str);
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        } catch (TException e) {
//            e.printStackTrace();
//        }
//    }
//}
