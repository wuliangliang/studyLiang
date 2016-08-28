package leetcode.string;

import org.junit.Test;

/**
 * Created by baidu on 16/7/12.
 */
public class reverseVowels {

    public String reverseVowels(String s) {
        String vowels = "aoeiuAOEIU";
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - i - 1;
        while (i < j) {
            while (i < j && !vowels.contains(a[i] + "")) {
                i++;
            }
            while (i < j && !vowels.contains(a[j] + "")) {
                j--;
            }
            if (i < j) {
                char c = a[i];
                a[i++] = a[j];
                a[j--] = c;
            }
        }

        return new String(a);
    }


    @Test
    public void test(){
        System.out.println(isPowerOfThree(177147));
    }
    public boolean isPowerOfThree(int n) {
        while (n>0 && (n % 3 == 0)) {
            n /= 3;
        }
        return n == 1;
    }
    static public int log(double value, double base) {
        System.out.println( (int)Math.log(value) / (int)Math.log(base));
        System.out.println( Math.log(value) / Math.log(base));
        System.out.println((int)(Math.log(value) / Math.log(base)));
        return (int)((int)Math.log(value) / (int)Math.log(base));
    }
}

