package com.pachong.testCrawler;

import com.pachong.util.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by doubling on 2016/12/2.
 */
public class UserId {
    /*
     *负责爬取解析用户的url；每天更新cookie（没有摸拟登陆，只能这样先弄）


    public static void Main(int page,String storeFile) throws IOException, InterruptedException {

        HashSet<String> urlSet = new HashSet<>();
       // String xiangxi = "/Users/doubling/Desktop/pachong/urlUser3.txt";
        BufferedWriter bw = FileUtil.writeToFile(storeFile);
        for (int i = 1; i <= page; i++) {

            //爬去页面

            String jsonUrl = "http://d.weibo.com/1087030002_2975_5013_0?page=" + i + "#Pl_Core_F4RightUserList__4";
            Document doc = Jsoup.connect(jsonUrl).
                    header("Host", "weibo.com").
                    header("Cookie", "SINAGLOBAL=5062928257090.655.1480599492831; YF-Ugrow-G0=56862bac2f6bf97368b95873bc687eef; login_sid_t=3e864946e3b24f0b2de52d0b3922211e; YF-V5-G0=c998e7c570da2f8537944063e27af755; WBStorage=2c466cc84b6dda21|undefined; _s_tentry=-; Apache=8019749873107.265.1480642406701; wb_bub_find=1; ULV=1480642406755:2:2:2:8019749873107.265.1480642406701:1480599492895; SCF=AsGajyB6kiIpJ8-YWSllWtiSqHwqCaLEYstLFIYI5NbzuHT0XP-Ktl0XUYnOueHnRYiwhUGltwUfF8WQwefM1Fg.; SUB=_2A251RL8jDeTxGeNO71AS8yjEyT2IHXVWM5frrDV8PUNbmtBeLXHTkW8uaD4NCjAN1_Z2w5QiMlL58VSXvQ..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWGJi2-IpUM7QsdZ-pIm-Vm5JpX5K2hUgL.Fo-7Shz0e0qReo22dJLoI7U_Ig_LUNy7; SUHB=0pHhZn2H4ZZZhn; ALF=1512178418; SSOLoginState=1480642419; un=mikewxp@163.com; wvr=6; wb_bub_find_5042336821=1; YF-Page-G0=3d55e26bde550ac7b0d32a2ad7d6fa53").
                    userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36").timeout(10000).get();
            String buffer = doc.toString();

            //每隔1000mm爬取一次

            Thread.sleep(1000);

            //对页面进行解析

            Document document = Jsoup.parse(buffer);
            Elements nodes = document.getElementsByTag("script");
            String str = nodes.get(nodes.size() - 1).toString();
            int end = 0;
            while (str != null) {
                end = str.indexOf("usercard");
                if (end == -1) {
                    break;
                }
                String uid = str.substring(end + 14, end + 24);
                if (!urlSet.contains(uid)) {
                    urlSet.add(uid);
                }
                str = str.substring(end + 13);
            }
            System.out.println("第"+i+"页已经完成");
        }

        //最后将url写入文件

        for(String str:urlSet){
            bw.write(str);
            bw.write("\n");
        }
        bw.close();
        System.out.println(urlSet.size());
    }
*/
}
