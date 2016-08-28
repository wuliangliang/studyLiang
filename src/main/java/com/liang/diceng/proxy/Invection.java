package com.liang.diceng.proxy;

/**
 * Created by liang on 16/5/19.
 */
public class Invection {
    public static void main(String[] args) throws Throwable {
        DynamicProxy dynamicProxy = new DynamicProxy(new UserManageImpl());
        UserManage userManage =(UserManage)dynamicProxy.newProxy();
        userManage.add("liangliang","wulllll");
    }
}
