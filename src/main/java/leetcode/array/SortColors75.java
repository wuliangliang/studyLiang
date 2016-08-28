package leetcode.array;

/**
 * Created by baidu on 16/8/23.
 */
public class SortColors75 {
    /*
    75. Sort Colors  QuestionEditorial Solution  My Submissions
    Total Accepted: 112086
    Total Submissions: 314509
    Difficulty: Medium
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.

    click to show follow up.

    Subscribe to see which companies asked this question

    Hide Tags
     */
    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public void sortColors(int[] A) {
        int len = A.length;
        int i, r = 0, b = 0;
        for (i = 0; i < len-b; i++) {
            if (A[i] == 0) {
                swap(A, i, r);
                r++;
            } else if (A[i] == 2) {
                swap(A, i, len-1-b);
                b++;
                i--; //后面交换过来的元素也要进行判断
            }
        }
    }
}
