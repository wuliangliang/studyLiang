package leetcode.dynamic;

/**
 * Created by doubling on 16/7/20.
 */
public class UniquePaths62 {
    /*
    62. Unique Paths  QuestionEditorial Solution  My Submissions
    Total Accepted: 101280
    Total Submissions: 268411
    Difficulty: Medium
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
     */
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return 0;
        }
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            a[i][0] = 1;
        }
        for(int j=0;j<n;j++)
            a[0][j]=1;


        for(int i=1;i<m;i++)
            for(int  j=1;j<n;j++)
                a[i][j]=a[i-1][j] + a[i][j-1];
        return a[m-1][n-1];

    }
}