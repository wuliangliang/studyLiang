package com.copyMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

/**
 * Created by doubling on 2016/11/14.
 */
public class c3p0Util {
    static ComboPooledDataSource rucLaw=null;
    static ComboPooledDataSource event=null;
    static{
        //这里有个优点，写好配置文件，想换数据库，简单
        //cpds = new ComboPooledDataSource("oracle");//这是oracle数据库
        rucLaw = new ComboPooledDataSource("ruclaw");//这是rucLaw数据库
        event = new ComboPooledDataSource("EventTeller");//这是event数据库
    }
    /**
     * 获得数据库连接
     * @return   Connection
     */
    public static Connection getRucLawConnection(){
        try {
            return rucLaw.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Connection getEventConnection(){
        try {
            return event.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据库关闭操作
     * @param conn
     * @param
     * @param pst
     * @param rs
     */
    public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 测试DBUtil类
     * @param
     */

    public static void main(String[] args) {
        Connection conn=getEventConnection();
        System.out.println("gfdgfdgfdg");
       // System.out.println(conn.getClass().getName());
        System.out.println("gdfgdg");
        close(conn,null,null);
    }
}
