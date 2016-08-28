package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/8/11.
 */
public class SpiralMatrix54 {
    /*
    54. Spiral Matrix  QuestionEditorial Solution  My Submissions
    Total Accepted: 67765
    Total Submissions: 289535
    Difficulty: Medium
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    For example,
    Given the following matrix:

    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    You should return [1,2,3,6,9,8,7,4,5].
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0;
        int y=0;
        while(m>0&&n>0){
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        return result;
    }

    /*
    59. Spiral Matrix II  QuestionEditorial Solution  My Submissions
    Total Accepted: 59588
    Total Submissions: 164171
    Difficulty: Medium
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0 ;
        int bottom = n-1;
        int left = 0 ;
        int right = n-1;
        int k =1 ;
        while(k<=n*n){
            for(int i=left; i<=right; i++){
                result[top][i]=k;
                k++;
            }
            top++;
            for(int i=top; i<=bottom; i++){
                result[i][right]=k;
                k++;
            }
            right--;
            for(int i=right; i>=left; i--){
                result[bottom][i]=k;
                k++;
            }
            bottom--;
            for(int i=bottom; i>=top; i--){
                result[i][left] = k;
                k++;
            }
            left++;
        }
        return result;
    }
}
