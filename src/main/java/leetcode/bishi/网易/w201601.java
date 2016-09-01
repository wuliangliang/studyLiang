package leetcode.bishi.网易;

import java.util.Scanner;

/**
 * Created by doubling on 16/8/28.
 */
public class w201601 {
    /*

    [编程题] 合唱团
    有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
    输入描述:
    每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。


    输出描述:
    输出一行表示最大的乘积。

    输入例子:
    3
    7 4 7
    2 50

    输出例子:
    49
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int stuN = scanner.nextInt();
            int[] soc = new int[stuN+1];
            for(int i =1 ; i  < soc.length; i ++){
                soc[i] = scanner.nextInt();
            }
            int selK = scanner.nextInt();
            int dis = scanner.nextInt();


        }
    }

    public static void solve(int stuN,int[] soc,int selK,int dis){
        try{
            long[][] max = new long[selK+1][stuN+1];
            long[][] min = new long[selK+1][stuN+1];
            for(int i = 1 ; i<=stuN; i ++){
                max[1][i] =min[1][i] = soc[i];
            }
            for(int i = 1; i <= stuN;i ++){
                for(int k =2; k<= selK;k++){
                    for(int j =i-1;j>0&&i-j<=dis;j--){
                        max[k][i] = Math.max(max[k][i],Math.max((max[k - 1][j] * soc[i]), (min[k - 1][j] * soc[i])));
                        min[k][i] = Math.min(min[k][i],Math.min((max[k - 1][j] * soc[i]), (min[k - 1][j] * soc[i])));
                    }
                }
            }
            long m = Long.MIN_VALUE;
            for(int i = 0 ; i < stuN+1;i++){
                if(max[selK][i]>m){
                    m=max[selK][i];
                }
            }
            System.out.println(m);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
