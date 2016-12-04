package com.pachong.xinlang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;

//url,uid,发帖时间,内容（最好三部分：自己内容,转发内容,转发url）
public class start {
	private static String todayDate = "";
	private static CsvWriter outputCsv = null;
	private static void init(String outputFile) throws UnsupportedEncodingException, FileNotFoundException{
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:/Task任务/吴亮亮爬取微博/result_"+ System.currentTimeMillis(), false),"utf-8"));
		outputCsv = new CsvWriter(output, ',');
		
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果
		System.out.println(date);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 todayDate = formatter.format(date);
	}
	private static String urlRawPre = "http://m.weibo.com/";
//	http://m.weibo.cn/page/json?containerid=1005051916655407_-_WEIBO_SECOND_PROFILE_WEIBO&page=2
	private static String jsonUrlPre = "http://m.weibo.cn/page/json?containerid=";
	private static String jsonUrlMiddle = "_-_WEIBO_SECOND_PROFILE_WEIBO&page=";
	

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
	public static void crawlHelper(String uid) throws IOException{
		String urlRaw = urlRawPre + uid;//http://m.weibo.com/208392828
		String containId = CrawlerParse.parseContainId(urlRaw);
		for(int pageNum = 1;pageNum < 50;pageNum ++){//判断时间and终止条件//最后一页
			String jsonUrl = jsonUrlPre + containId + jsonUrlMiddle + pageNum;
			String jsonDoc = CrawlerParse.getReturnData(jsonUrl);//你知道
			if(jsonDoc.length() < 150 || jsonDoc.contains("\"msg\":\"\u6ca1\u6709\u5185\u5bb9\"}") || jsonDoc.contains("\"msg\":\"没有内容\"")){
				continue;
			}
			//这个下面就是解析json得到多个time和content
			parserJson(uid,jsonDoc);
			System.out.println(jsonUrl);
		}
	}
	public static void close(){
		outputCsv.close();
	}
	public static void crawlInput(String inputFile) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "utf-8"));
		String line = "";
		while((line = input.readLine()) != null){
			System.out.println(line);
			String lineSeg[] = line.split("\t");
			String url = lineSeg[3];//
			int start = url.indexOf(".com/u/");
			if(start == -1){
				start = url.indexOf(".com/") + ".com/".length();
			}else{
				start = start + ".com/u/".length();
			}
			String uid = url.substring(start,url.indexOf("?refer"));
			if(crawlerUtil.isNums(uid)){
				crawlHelper(uid);
			}
		}//while((line = input.readLine()) != null){
		
		input.close();
	}
	
	public static void main(String[] args) throws IOException {
		init("H:/Task任务/吴亮亮爬取微博/result");//这个是初始化输出结果文件
		crawlInput("H:/Task任务/吴亮亮爬取微博/法律url.txt");

		close();
	}
}
