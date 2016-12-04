package com.pachong.xinlang;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by doubling on 2016/12/2.
 */
public class CrawlerParse {


    private static String todayDate = "";
    private static CsvWriter outputCsv = null;
    public static String parseContainId(String urlRaw) throws IOException{
        Document doc = Jsoup.connect(urlRaw).timeout(5000).userAgent("").get();
        String docStr = doc.toString();
        int start = docStr.indexOf("\"containerid\":\"") + "\"containerid\":\"".length();
        int end = docStr.indexOf("\",\"",start);
        return docStr.substring(start, end);
    }
    public static String getReturnData(String urlString) throws UnsupportedEncodingException {
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", "_T_WM=82064b15de685df65d2c80d3a2b562e1; ALF=1483234419; SCF=AsGajyB6kiIpJ8-YWSllWtiSqHwqCaLEYstLFIYI5NbzW7rbfrndKnPqfzem87G-2y2kMw7_tuuB8F_q3pInpEI.; SUB=_2A251RKQhDeTxGeNO71AS8yjEyT2IHXVWxsxprDV6PUJbktBeLUf1kW0B2kTOaeLZtqjL6GlAsEF6wQXA0w..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWGJi2-IpUM7QsdZ-pIm-Vm5JpX5o2p5NHD95QfehBEe0ec1hzpWs4DqcjGdgLu9PURM5tt; SUHB=0XD1rf87ljqTpU; SSOLoginState=1480643697");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            conn.setReadTimeout(5000);
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line;
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        return res;
    }

    /**
     * 解析json得到多个time和content 并写文件
     * @param uid
     * @param jsonStr
     * @throws IOException
     */

    public static void parserJson(String uid,String jsonStr) throws IOException{
        JSONObject json = JSONObject.parseObject(jsonStr);
        JSONArray jarr = json.getJSONArray("cards");
        JSONObject obj = jarr.getJSONObject(0);
        JSONArray dataArr = obj.getJSONArray("card_group");
        String time = "";
        String content = "";
        String retweeted_statusText = "";
        for(int i = 0;i < dataArr.size();i ++){
            JSONObject dataObj = dataArr.getJSONObject(i);
            JSONObject mblog = dataObj.getJSONObject("mblog");
            time = mblog.getString("created_at");
            time = time.replace("今天", todayDate);
            if(!time.trim().startsWith("2016")){
                time = "2016-" + time;
            }

            content = mblog.getString("text");
            JSONObject retweeted_status = mblog.getJSONObject("retweeted_status");
            try{
                retweeted_statusText = retweeted_status.getString("text");
            }catch(NullPointerException e){
                retweeted_statusText = "";
            }
            String[] record = new String[]{uid,time,content,retweeted_statusText};
            outputCsv.writeRecord(record);
        }
    }
}
