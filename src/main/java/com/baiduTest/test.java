package com.baiduTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by baidu on 16/8/3.
 */
public class test {
    private static String REGEX =
            "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private static final String REG_EMAIL = "^[\\w\\-\\.]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("/Users/baidu/Work/data/email.csv"));
        List<String> mailList = new ArrayList<String>();
        while(scanner.hasNext()){

            String line = scanner.nextLine();
            if(line.contains("\"")){
                System.out.println(line);
            }

            String[] lines = scanner.nextLine().split(";");
            if(lines.length>0){
                List listtemp=Arrays.asList(lines);
                mailList.addAll(listtemp);
            }
        }
        System.out.println(mailList.size());
        Iterator it = mailList.iterator();
        List<String> strRm = new ArrayList<>();
        while(it.hasNext()){
            String  str = it.next().toString();
            if(str.contains("(")){
                it.remove();
                String temp = str.substring(0,str.indexOf("("));
                strRm.add(temp);
            }
        }


        List<String> REGEXLIST= new ArrayList<>();
        for(String str:mailList){
            if(!str.matches(REGEX)){
                REGEXLIST.add(str);
                System.out.println(str);
            }
        }
        Collections.sort(REGEXLIST);

        List<String> REG_EMAILLIST= new ArrayList<>();
        for(String str:mailList){
            if(str.contains("\""))
                System.out.println(str);
            if(!str.matches(REG_EMAIL)){
                REG_EMAILLIST.add(str);
                System.out.println(str);
            }
        }
        Collections.sort(REG_EMAILLIST);
//        System.out.println(REGEXLIST);
//        System.out.println(REG_EMAILLIST);
    }


}
