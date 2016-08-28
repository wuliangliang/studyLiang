package leetcode;

import org.junit.Test;

/**
 * Created by baidu on 16/7/11.
 */
public class leetcodeTest {
    public static void main(String[] args) throws Exception {
        System.out.println(reverse(646324351));
        System.out.println("dsfdsfsdfsd");
        System.out.println(Integer.MAX_VALUE);
        //System.out.println(9646324351);
    }
    @Test
    public void convert(){
        //System.out.println(convert("PAYPALISHIRING",7));
        //System.out.println(reverse(-23232));
        System.out.println(myAtoi("12"));
    }


    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        char charR[] = new char[length];
        int k = 0;
        for(int i = 0 ; i<numRows-1;i++){
            for(int j =i ;j<= length;j+=(numRows-i)*2-2){
                if(j<=length-1) {
                    charR[k] = chars[j];
                    k++;
                }
            }
        }
        return new String(charR);
    }


    public static int  reverse(int x) throws Exception {
        if(x==Integer.MIN_VALUE||x>Integer.MAX_VALUE)
            return 0;
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char[] charR = new char[chars.length];
        int length = chars.length;
        int k =0;

        if(chars[0]=='-'){
            charR[0]='-';
            k=k+1;
        }
        for(int j = k ;j<chars.length;j++){
            charR[j]=chars[length-1];
            length--;
        }
        String ste =String.valueOf(charR);
        int e = Integer.valueOf(ste);
        return e;
    }
    public int reverse2(int x) {
        if(x==Integer.MIN_VALUE)
            return 0;
        int num = Math.abs(x);
        int res = 0;
        while(num!=0)
        {
            if(res>(Integer.MAX_VALUE-num%10)/10)
                return 0;
            res = res*10+num%10;
            num /= 10;
        }
        return x>0?res:-res;
    }
/*
    第二种方法是去头尾两个数字,然后比较
 */
    public boolean isPalindrome(int x) {
        int max = x;
        int min = 0;
        while(max >0){
            min *= 10;
            min+= max %10;
            max /=10;
        }
        return min==x;
    }

    public int myAtoi(String str){
        int max= Integer.MAX_VALUE;
        int min =-Integer.MIN_VALUE;
        long result = 0;
        boolean neg = false;
        int start = 0;
        int length = str.length();
        if (length < 1)
            return 0;
        if(str.charAt(start)=='-'||str.charAt(start)=='+'){
            if(str.charAt(start)=='-'){
                neg=true;
            }
        }
        for(int i = start;i<length;i++){
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            result = 10 * result + (ch - '0');
            if (!neg && result > max)
                return max;
            if (neg && -result < min)
                return min;
        }
        if (neg)
            result = -result;
        return (int) result;
    }
    int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    int romanToInt(String s) {
        int ret = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))) {
                ret += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i-1));
            } else {
                ret += toNumber(s.charAt(i));
            }
        }
        return ret;
    }
}

