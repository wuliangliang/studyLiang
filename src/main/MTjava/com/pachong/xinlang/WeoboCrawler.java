package com.pachong.xinlang;

import java.io.IOException;

/**
 * Created by doubling on 2016/12/2.
 */
public class WeoboCrawler {

    public static void main(String[] args) throws IOException, InterruptedException {

        //在找人页面get到uid，保存在uid的文件里面。
        String xiangxi = "/Users/doubling/Desktop/pachong/UserId.txt";   //文件保存路径
        CrawlerHelper.getUrl(171,xiangxi);
        CrawlerHelper.init("H:/Task任务/吴亮亮爬取微博/result");//这个是初始化输出结果文件
        CrawlerHelper.crawlInput(xiangxi);
    }
}
