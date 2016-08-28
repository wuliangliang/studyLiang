package leetcode.bishi.网易;

import java.util.Scanner;

/**
 * Created by doubling on 16/8/28.
 */
public class w201603 {
    /*
    [编程题] 分苹果
    n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
    输入描述:
    每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。


    输出描述:
    输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。

    输入例子:
    4
    7 15 9 5

    输出例子:
    3
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n  = scanner.nextInt();
            int[] a = new int[n];
            for(int i  = 0 ; i < n ; i ++){
                a[i]  = scanner.nextInt();
            }

            int sum = 0 ;
            for(int i = 0 ; i < n ; i++){
                sum += a[i];
            }


            int count = 0 ;
            if(sum%n!=0){
                System.out.println(-1);
            }else{
                int avg = sum/n;
                for(int j = 0 ; j < n ; j++){
                    if(a[j]>avg){
                        if((a[j]-avg)%2==0){
                            count += (a[j]-avg)/2;
                        }else{
                            System.out.println(-1);
                        }

                    }
                    if(j==n-1){
                        System.out.println(count);
                    }
                }
            }

        }
    }
}
