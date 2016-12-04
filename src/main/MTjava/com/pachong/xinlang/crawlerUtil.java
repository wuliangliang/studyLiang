package com.pachong.xinlang;

import java.util.regex.Pattern;

/**
 * Created by doubling on 2016/12/2.
 */
public class crawlerUtil {
    public static boolean isNums(String uid){
        Pattern FILTERS = Pattern.compile("[0-9]+$");
        return FILTERS.matcher(uid).matches();
    }
}
