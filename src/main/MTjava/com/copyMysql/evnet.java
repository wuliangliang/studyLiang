package com.copyMysql;

import org.junit.Test;

import java.sql.*;

/**
 * Created by doubling on 2016/11/14.
 */
public class evnet {
    @Test
    public void test() {
        Connection event = c3p0Util.getEventConnection();

        System.out.println(event.getClass().getName());
       // Connection law = c3p0Util.getRucLawConnection();
//        try {
//            Statement st = event.createStatement();
//            String sql = "select * from Event";
//            ResultSet set = st.executeQuery(sql);
//            int columnNum = set.getMetaData().getColumnCount();
//            while(set.next()){
//                for(int i =0 ; i < columnNum;i++){
//                    System.out.println(set.getString(i+1));
//                }
//                System.out.println();
//            }
//            System.out.println(set.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }


    @Test
    public void testLaw(){
        try {
            Connection rucLaw = JdbcUtil.getConnection();
            Statement st  = rucLaw.createStatement();

            String sqlInsert = "insert into lawevent values(?,?,?,?,?,?,?,?,?)" ;

            String sql = "select * from fagui";
            ResultSet set = st.executeQuery(sql);
            int columnNum = set.getMetaData().getColumnCount();
            while(set.next()){

                for(int i = 1 ;i< columnNum;i++){
                    System.out.println(set.getString(i));
                }
                System.out.println();
//                String title = set.getString(2);
//                Date pubtime = set.getDate(3);
//                String content = set.getString(4);
//                String source = set.getString(5);
//                String imgs = set.getString(6);
//                int numbers=set.getInt(7);
//                int day = set.getInt(8);
//                int topic = set.getInt(9);
//                PreparedStatement stRucLaw = rucLaw.prepareStatement(sqlInsert);
//                stRucLaw.setString(2,title);
//                stRucLaw.setDate(3,pubtime);
//                stRucLaw.setString(4,content);
//                stRucLaw.setString(5,source);
//                stRucLaw.setString(6,imgs);
//                stRucLaw.setInt(7,numbers);
//                stRucLaw.setInt(8,day);
//                stRucLaw.setInt(9,topic);
//
//                System.out.println(title);
//                System.out.println("------------");
//                System.out.println(pubtime);
//                System.out.println("------------");
//                System.out.println(content);
//                System.out.println("------------");
//                System.out.println(source);
//                System.out.println("------------");
//                System.out.println(imgs);
//                System.out.println("------------");
//                System.out.println(numbers);
//                System.out.println("------------");
//                System.out.println(day);
//                System.out.println("------------");
//                System.out.println(topic);
//
//                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testEvent(){
        try {
            Connection event = JdbcUtil.getEventConnection();
            Statement st  = event.createStatement();

            String sqlInsert = "insert into lawevent values(?,?,?,?,?,?,?,?,?)" ;

            String sql = "select MAX(topic) from Event";
            ResultSet set = st.executeQuery(sql);
            int columnNum = set.getMetaData().getColumnCount();
            while(set.next()){

                for(int i = 1 ;i< columnNum;i++){
                    System.out.println(set.getString(i));
                }
                System.out.println();
//                String title = set.getString(2);
//                Date pubtime = set.getDate(3);
//                String content = set.getString(4);
//                String source = set.getString(5);
//                String imgs = set.getString(6);
//                int numbers=set.getInt(7);
//                int day = set.getInt(8);
//                int topic = set.getInt(9);
//                PreparedStatement stRucLaw = rucLaw.prepareStatement(sqlInsert);
//                stRucLaw.setString(2,title);
//                stRucLaw.setDate(3,pubtime);
//                stRucLaw.setString(4,content);
//                stRucLaw.setString(5,source);
//                stRucLaw.setString(6,imgs);
//                stRucLaw.setInt(7,numbers);
//                stRucLaw.setInt(8,day);
//                stRucLaw.setInt(9,topic);
//
//                System.out.println(title);
//                System.out.println("------------");
//                System.out.println(pubtime);
//                System.out.println("------------");
//                System.out.println(content);
//                System.out.println("------------");
//                System.out.println(source);
//                System.out.println("------------");
//                System.out.println(imgs);
//                System.out.println("------------");
//                System.out.println(numbers);
//                System.out.println("------------");
//                System.out.println(day);
//                System.out.println("------------");
//                System.out.println(topic);
//
//                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void copy(){
        try {
            Connection rucLaw = JdbcUtil.getConnection();
            Connection conEvent = JdbcUtil.getEventConnection();
            Statement st  = conEvent.createStatement();

            String sqlInsert = "insert into lawevent values(?,?,?,?,?,?,?,?,?)" ;

            String sql = "select * from Event where topic= 4096";
            ResultSet set = st.executeQuery(sql);
//            int columnNum = set.getMetaData().getColumnCount();
            while(set.next()){
                int id = set.getInt(1);
                String title = set.getString(2);
                Date pubtime = set.getDate(3);
                String content = set.getString(4);
                String source = set.getString(5);
                String imgs = set.getString(6);
                int numbers=set.getInt(7);
                int day = set.getInt(8);
                int topic = set.getInt(9);
                PreparedStatement stRucLaw = rucLaw.prepareStatement(sqlInsert);
                stRucLaw.setInt(1,id);
                stRucLaw.setString(2,title);
                stRucLaw.setDate(3,pubtime);
                stRucLaw.setString(4,content);
                stRucLaw.setString(5,source);
                stRucLaw.setString(6,imgs);
                stRucLaw.setInt(7,numbers);
                stRucLaw.setInt(8,day);
                stRucLaw.setInt(9,topic);

//                stRucLaw.setString(2,title);
//                stRucLaw.setDate(3,pubtime);
//                stRucLaw.setString(4,content);
//                stRucLaw.setString(5,source);
//                stRucLaw.setString(6,imgs);
//                stRucLaw.setInt(7,numbers);
//                stRucLaw.setInt(8,day);
//                stRucLaw.setInt(9,topic);
                stRucLaw.executeUpdate();
                System.out.println(title);
                System.out.println("------------");
                System.out.println(pubtime);
                System.out.println("------------");
                System.out.println(content);
                System.out.println("------------");
                System.out.println(source);
                System.out.println("------------");
                System.out.println(imgs);
                System.out.println("------------");
                System.out.println(numbers);
                System.out.println("------------");
                System.out.println(day);
                System.out.println("------------");
                System.out.println(topic);

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
