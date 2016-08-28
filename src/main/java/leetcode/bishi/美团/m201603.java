package leetcode.bishi.美团;

/**
 * Created by baidu on 16/8/24.
 */
public class m201603 {
    /*
    题目描述

    有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
    比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
    给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
    测试样例：
    [2,7,9,4,1],5
    返回：14
     */

    public int countArea(int[] A, int n) {
        // write code here
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = A[i];
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i][j - 1], A[j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int width = 1;
            for (int j = i + 1; j < n; ++j) {
                ++width;
                dp[i][j] = dp[i][j] * width;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
