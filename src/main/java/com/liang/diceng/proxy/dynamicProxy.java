package com.liang.diceng.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liang on 16/5/19.
 */
 class DynamicProxy implements InvocationHandler {
    private UserManage userManage;
    public DynamicProxy(UserManage userManage)
    {
        this.userManage = userManage;
    }
    public Object newProxy() throws Throwable {
        //返回一个代理对象
        return Proxy.newProxyInstance(userManage.getClass().getClassLoader(),userManage.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            result = method.invoke(userManage,args);
            check();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void check(){
        System.out.println("通过代理执行该方法");
    }
}
