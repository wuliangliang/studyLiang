package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 16/7/14.
 */
public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        char[] pa = pattern.toCharArray();
        Map<Character,String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if(pa.length!= strs.length){
            return false;
        }
        for(int i = 0 ; i < pa.length ; i++){
            char temp = pa[i];
            if(map.containsKey(temp)){
                String value = map.get(temp);
                if(!value.equals(strs[i]))
                    return false;
            }else{
                if(map.containsValue(strs[i]))
                    return false;
                map.put(temp,strs[i]);
            }
        }
        return true;
    }
}
