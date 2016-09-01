package leetcode.dynamic;

/**
 * Created by baidu on 16/9/1.
 */
public class DistinctSubsequences115 {
    /*
    115. Distinct Subsequences  QuestionEditorial Solution  My Submissions
    Total Accepted: 56925
    Total Submissions: 190894
    Difficulty: Hard
    Given a string S and a string T, count the number of distinct subsequences of T in S.

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

    Here is an example:
    S = "rabbbit", T = "rabbit"

    Return 3.

    题意解读：只可以用删除字符的方法从第一个字符串变换到第二个字符串，求出一共有多少种变换方法。
    解题分析：dfs可以做，但大数据超时。
    动态规划，定义dp[i][j]为字符串i变换到j的变换方法。
    如果S[i]==T[j]，那么dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。意思是：如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。
    如果S[i]!=T[i]，那么dp[i][j] = dp[i-1][j]，意思是如果当前字符不等，那么就只能抛弃当前这个字符。
    递归公式中用到的dp[0][0] = 1，dp[i][0] = 0（把任意一个字符串变换为一个空串只有一个方法）
         */
    public static int numDistinct(String S, String T) {
        if(S==null||T==null) {
            return 0;
        }
        if(S.length()<T.length()) {
            return 0;
        }
        int [][] dp = new int[S.length()+1][T.length()+1];
        dp[0][0] = 1;
        //任意一个字符串变换成一个空串都只有一种变换方法
        for(int i=0;i<S.length();i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=S.length();i++) {
            for(int j=1;j<=T.length();j++) {
                System.out.println(dp[i-1][j]);
                //如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }

    public static void main(String[] args) {
        int res =numDistinct("rababit","rabbit");
        System.out.println(res);

    }
}
