package leetcode.dynamic;

/**
 * Created by baidu on 16/9/1.
 */
public class DecodeWays91 {
    /*
    91. Decode Ways  QuestionEditorial Solution  My Submissions
    Total Accepted: 81454
    Total Submissions: 448887
    Difficulty: Medium
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.
     */
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        int num1 = 1;
        int num2 = 1;
        int num3 = 1;
        for(int i = 1 ; i < s.length();i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    num3=num1;
                }else{
                    return 0;
                }
            }
            else{
                if(s.charAt(i-1)=='0' || s.charAt(i-1)>='3')
                    num3 = num2;
                else
                {
                    if(s.charAt(i-1)=='2' && s.charAt(i)>='7' && s.charAt(i)<='9')
                        num3 = num2;
                    else
                        num3 = num1+num2;
                }

            }
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}
