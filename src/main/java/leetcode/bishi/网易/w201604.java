package leetcode.bishi.网易;

import java.util.Scanner;

/**
 * Created by doubling on 16/8/28.
 */
public class w201604 {
    /*
     [编程题] 数列还原
     牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
     输入描述:
     每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。


     输出描述:
     输出一行表示合法的排列数目。

     输入例子:
     5 5
     4 0 0 2 0

     输出例子:
     2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a= new int[n];
            for(int i = 0 ; i < n  ; i ++){
                a[i]= scanner.nextInt();
            }


        }

    }
}
