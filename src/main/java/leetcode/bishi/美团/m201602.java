package leetcode.bishi.美团;

import java.util.Scanner;

/**
 * Created by baidu on 16/8/24.
 */

    /*

    题目描述

    求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。

    输入描述:
    每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）


    输出描述:
    输出答案。

    输入例子:
    ab ce 1 2

    输出例子:
    56


    想明白了思路就很简单，代码也很少。
    求解大于str1的字符串个数以及大于str2的字符串个数，然后两者相减就能得到处于str1和str2之间的字符串个数
    对于求解长度len在[len1,len2]之间，且字典序大于某个字符串(str)的字符串个数：
    顺序遍历(i=0:n-1)str的每个字符str[i]，则若一个字符串destr大于str，则有两种情况：
    (1)destr第i个字符大于str[i]，则之后的字符无论是什么，destr都大于str
    (2)destr第i个字符等于str[i]，则i++，并继续讨论后续字符
    最后如果len>strLen，需要考虑destr前strLen位和str完全一样，则剩余位置字符可以是任意字符。

     */




public class m201602 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String[] array = s.split(" ");

            int min = Integer.parseInt(array[2]);
            int max = Integer.parseInt(array[3]);
            char[] ar = array[0].toCharArray();
            char[] br = array[1].toCharArray();
            long sum = 0;
            for (int i = min; i <= max; i++) {
                char a = ar[0];
                char b = br[0];
                sum += (long) Math.pow(26, i - 1) * (b - a);
                long suma = 0;
                long sumb = 0;
                for (int j = 1; j < ar.length; j++)// 找到比ar剩余字符串小的字符串个数
                {
                    suma = suma + (ar[j] - 'a') * (long) Math.pow(26, i - 1 - j);
                }
                for (int j = 1; j < br.length; j++)// 找到比br剩余字符串小的字符串个数
                {
                    sumb = sumb + (br[j] - 'a') * (long) Math.pow(26, i - 1 - j);
                }

                sum = sum + sumb - suma;
            }
            sum--;
            System.out.println(sum % 1000007);
        }
    }
}
