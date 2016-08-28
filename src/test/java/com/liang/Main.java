package com.liang;

import java.util.*;

/**
 * Created by doubling on 16/8/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String>  set = new HashSet<String>();
        while(scanner.hasNext()){
            String line  = scanner.nextLine();
            String[] words = line.split(" ");
            for(String str: words){
                set.add(str);
            }
        }
        System.out.println(set.size());
        scanner.close();
    }
}
