package com.liang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liang on 16/5/18.
 */
public class dataUtil {

    public static int  dataBetween(String beforDate,String endDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date befor = simpleDateFormat.parse(beforDate);
        System.out.println(befor);
        Date end = simpleDateFormat.parse(endDate);
        long beforTime = befor.getTime();
        long endTime = end.getTime();
        return (int)(beforTime-endTime)/(24*60*60*1000);
    }

    public static void main(String[] args) throws ParseException {
       int d =  dataBetween("2015-05-18","2015-05-17");
        System.out.println(d);
    }
}
