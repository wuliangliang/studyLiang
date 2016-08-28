package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/8/11.
 */
public class AddBinary67 {

    /*
        Given two binary strings, return their sum (also a binary string).

        For example,
        a = "11"
        b = "1"
        Return "100".

        Subscribe to see which companies asked this question
         */
    public String listToString(List<Character> li) {
        StringBuffer str = new StringBuffer();

        for(int i = 0;i<=li.size()-1;i++)
        {
            str.append(li.get(i));
        }
        return str.toString();
    }
    public String addBinary(String a, String b) {


        int alen =a.length();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int blen = b.length();
        if(alen==0)
        {
            return b;
        }
        if(blen==0)
        {
            return a;
        }
        List<Character> ret =new ArrayList<>();
        int carry = 0;
        int aindex = alen-1;
        int bindex = blen-1;
        while(aindex>=0&&bindex>=0){
            int num = aa[aindex]-'0'+bb[bindex]-'0';
            carry  = num/2;
            num = num%2;
            aindex --;
            bindex--;
            ret.add(0, (char) (num+'0'));
        }
        if(alen<0&&blen<0)
        {
            if(carry==1)
            {
                ret.add(0, (char) (carry+'0'));
                return listToString(ret);
            }
        }
        while(aindex>=0)
        {
            int num = aa[aindex]-'0'+carry;
            carry  = num/2;
            num = num%2;
            aindex--;
            ret.add(0, (char) (num+'0'));
        }
        while(bindex>=0)
        {
            int num = bb[bindex]-'0'+carry;
            carry  = num/2;
            num = num%2;
            bindex--;
            ret.add(0, (char) (num+'0'));
        }
        if(carry==1)
        {
            ret.add(0, (char) (carry+'0'));
        }
        return listToString(ret);
    }
}
