package leetcode.bishi.美团;

import java.net.StandardSocketOptions;
import java.util.Scanner;

/**
 * Created by baidu on 16/8/24.
 */
public class m201601 {
    public static void main(String[] args) {

        //考虑每过一年,老员工增加一岁
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            double W = scanner.nextDouble();  //总人数
            double Y = scanner.nextDouble();  //平均年龄
            double x = scanner.nextDouble();    //流失率
            double n = scanner.nextDouble();  //
            for(int i = 0 ; i < n ; i ++){
                Y = ((W*(1-x))*(Y+1)+W*x*21)/W;
            }

            System.out.println(Math.ceil(Y));


        }
    }
}
