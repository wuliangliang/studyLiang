//package com.fenbushi.thrift.server;
//import org.apache.thrift.TProcessor;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TBinaryProtocol.Factory;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TThreadPoolServer;
//import org.apache.thrift.transport.TServerSocket;
//import service.demo.Hello;
///**
// * Created by liang on 16/5/25.
// */
//public class HelloServiceServer {
//    public static void main(String[] args) {
//        try {
//            // 设置服务端口为 7911
//            TServerSocket serverTransport = new TServerSocket(7911);
//            // 设置协议工厂为 TBinaryProtocol.Factory
//            Factory proFactory = new TBinaryProtocol.Factory();
//            // 关联处理器与 Hello 服务的实现
//            TProcessor processor = new Hello.Processor(new HelloServiceImpl());
//            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
//                    .protocolFactory(proFactory)
//                    .processor(processor)  );
//            System.out.println("Start server on port 7911...");
//            server.serve();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
