package leetcode.array;

/**
 * Created by baidu on 16/8/23.
 */
public class Searcha2DMatrix74 {
    /*
    74. Search a 2D Matrix  QuestionEditorial Solution  My Submissions
    Total Accepted: 90331
    Total Submissions: 259556
    Difficulty: Medium
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,

    Consider the following matrix:

    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    Given target = 3, return true.

    Subscribe to see which companies asked this question
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0 ;
        int end = m*n-1;

        while(start<=end){
            int mid = (start+end)/2;
            int midx = mid/n;
            int midy = mid%n;
            if(matrix[midx][midy]==target){
                return true;
            }if(matrix[midx][midy]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }
        return false;
    }


    /*
    240. Search a 2D Matrix II  QuestionEditorial Solution  My Submissions
    Total Accepted: 46771
    Total Submissions: 129341
    Difficulty: Medium
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    For example,

    Consider the following matrix:

    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
    Given target = 5, return true.

    Given target = 20, return false.

    Subscribe to see which companies asked this question
     */
}
