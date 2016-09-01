package leetcode.dynamic;

/**
 * Created by baidu on 16/9/1.
 */
public class EditDistance72 {
    /*
    72. Edit Distance  QuestionEditorial Solution  My Submissions
    Total Accepted: 66056
    Total Submissions: 222626
    Difficulty: Hard
    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        for(int i = 0 ; i < len1; i ++){
            for(int j =0 ; j < len2 ; j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
