package leetcode.bishi.美团;

/**
 * Created by baidu on 16/8/25.
 */
public class m201606 {
    /*
    题目描述

    在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),
    现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
    给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
    测试样例：
    [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
    返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
     */

    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        for (int i = 0; i < f.length; i++) {
            int row = f[i][0] - 1;
            int col = f[i][1] - 1;

            if (row - 1 >= 0) {
                A[row - 1][col] = (A[row - 1][col] == 0) ? 1 : 0;
            }

            if (row + 1 <= 3) {
                A[row + 1][col] = (A[row + 1][col]) == 0 ? 1 : 0;
            }

            if (col - 1 >= 0) {
                A[row][col - 1] = (A[row][col - 1]) == 0 ? 1 : 0;
            }

            if (col + 1 <= 3) {
                A[row][col + 1] = (A[row][col + 1]) == 0 ? 1 : 0;
            }
        }
        return A;
    }
}
