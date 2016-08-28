package com.liang.a;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 16/8/10.
 */

public class nihao {
    static Map<String ,Integer> map = java.util.Collections.synchronizedMap(new HashMap<String, Integer>());

    public static void main(String[] args) {

        while(true) {
            String s = "fdsfsd";
            System.out.println(s);
        }
//        System.out.println(s==s1);
//        System.out.println(s1==s2);
//        System.out.println(s2==s3);
//
//            long start = System.currentTimeMillis();
//            halou[] i = new halou[100000000];
//            long end = System.currentTimeMillis();
//            System.out.println("==============  "+(start- end));
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i = 0 ; i< 100 ; i++){
//                            new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                }
//                            }).start();
//                    }
//                }
//            });
    }

}
