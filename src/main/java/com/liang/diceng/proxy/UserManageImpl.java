package com.liang.diceng.proxy;

/**
 * Created by liang on 16/5/19.
 */
public class UserManageImpl implements UserManage{

    public void add(String userName, String passWord) {
        System.out.println("add:"+"userName"+userName+","+"password"+passWord);
    }

    public void find(String userName) {
        System.out.println("find : "+"userName");
    }
}
