package leetcode.array;

/**
 * Created by baidu on 16/8/11.
 */
public class PlusOne66 {
    /*
    66. Plus One  QuestionEditorial Solution  My Submissions
    Total Accepted: 115449
    Total Submissions: 328737
    Difficulty: Easy
    Given a non-negative number represented as an array of digits, plus one to the number.

    The digits are stored such that the most significant digit is at the head of the list.

    Subscribe to see which companies asked this question
     */
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i =digits.length-1 ; i >=0 ; i--){
            if(flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    flag = false;
                }
                if (i == 0 && digits[i] == 0) {
                    int[] newnums = new int[digits.length + 1];
                    newnums[0] = 1;
                    for (int j = 1; j <= digits.length; j++) {
                        newnums[j] = digits[j - 1];
                    }
                    digits = newnums;
                }
            }
        }
        return digits;
    }
}
