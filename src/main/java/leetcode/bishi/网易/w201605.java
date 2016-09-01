package leetcode.bishi.网易;

import sun.tools.tree.ArrayAccessExpression;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by baidu on 16/8/29.
 */
public class w201605 {
   /*
   [编程题] 幸运的袋子
    一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
    例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
    你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
    输入描述:
    第一行输入一个正整数n(n ≤ 1000)
    第二行为n个数正整数xi(xi ≤ 1000)


    输出描述:
    输出可以产生的幸运的袋子数

    输入例子:
    3
    1 1 1

    输出例子:
    2

    */
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int[] a =new int[n];
           for(int i = 0 ; i < n ; i++){
               a[i] =scanner.nextInt();
           }
           Arrays.sort(a);
           System.out.println(find(a,0,0,1));
       }
   }

    public static int find(int[] a,int index,int sum ,int multi){
        int count = 0 ;
        for(int i = index ; i < a.length ; i ++){
            sum += a[i];
            multi *= a[i];
            if(sum>multi){
                count += 1 + find(a, i+1, sum, multi);
            }else if(a[i] == 1){
                count = find(a, i+1, sum, multi);
            }else {
                break;
            }
            sum -= a[i];
            multi /= a[i];
            while (i<a.length-1 && a[i]==a[i+1])
                i++;
        }

        return count;
    }
}
