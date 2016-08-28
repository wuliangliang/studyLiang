package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by baidu on 16/8/23.
 */
public class setmatrixzeroes73 {
    /*
    73. Set Matrix Zeroes  QuestionEditorial Solution  My Submissions
    Total Accepted: 75039
    Total Submissions: 218627
    Difficulty: Medium
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

    click to show follow up.

    Subscribe to see which companies asked this question
     */
    public void setZeroes(int[][] matrix) {
        if(matrix!=null||matrix.length!=0||matrix[0].length!=0){
            int n = matrix.length;
            int m = matrix[0].length;
            Set<Integer> listx = new HashSet<>();
            Set<Integer> listy = new HashSet<>();

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(matrix[i][j]==0){
                        listx.add(i);
                        listy.add(j);
                    }
                }
            }
            if(listx.size()>0) {
                for (Integer x : listx) {
                    for (int f = 0; f < m; f++) {
                        matrix[x][f] = 0;
                    }
                }
            }
            if(listy.size()>0) {
                for (Integer y : listy) {
                    for (int f = 0; f < n; f++) {
                        matrix[f][y] = 0;
                    }
                }
            }
        }
    }
}
