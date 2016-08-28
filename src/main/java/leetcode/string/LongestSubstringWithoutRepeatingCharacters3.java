package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 16/8/12.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    /*
    3. Longest Substring Without Repeating Characters  QuestionEditorial Solution  My Submissions
    Total Accepted: 172804
    Total Submissions: 755377
    Difficulty: Medium
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Subscribe to see which companies asked this question
     */

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        //新建一个map进行存储char
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int leftBound = 0;
        int max = 0;
        for(int i=0; i<s.length();i++){
            char  c = s.charAt(i);
            //窗口左边可能为下一个char，或者不变
            leftBound = Math.max(leftBound,map.containsKey(c)? map.get(c)+1:0);
            max = Math.max(max, i-leftBound+1);//当前窗口长度
            map.put(c,i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
