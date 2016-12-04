package com.copyMysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by doubling on 2016/11/14.
 */

/**
 * 工具类
 * @author AdminTC
 */
public class JdbcUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    //private static String url = "jdbc:mysql://localhost:3306/ruc";
    private static String urlEvent ="jdbc:mysql://222.29.197.238:3306/EventTeller?useUnicode=true&amp;characterEncoding=utf8";
    private static String userEvent = "dbdm";
    private static String passwordEvent = "mysql@ET453";

    private static String url ="jdbc:mysql://localhost:3306/ruclaw?useUnicode=true&amp;characterEncoding=utf8&useSSL=true";
    private static String user = "root";
    private static String password = "root";


    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,password);
    }

    public static Connection getEventConnection() throws Exception{
        return DriverManager.getConnection(urlEvent,userEvent,passwordEvent);
    }
    public static void close(Connection conn) throws Exception{
        if(conn != null){
            conn.close();
        }
    }
    public static void close(Statement stmt) throws Exception{
        if(stmt != null){
            stmt.close();
        }
    }
    public static void close(ResultSet rs) throws Exception{
        if(rs != null){
            rs.close();
        }
    }
}




