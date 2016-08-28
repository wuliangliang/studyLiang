package leetcode.bishi;

import java.util.Scanner;

/**
 * Created by baidu on 16/7/18.
 */
public class WangYi2016 {
    static int hurt = 0;

    public static void main(String[] args) {
        System.out.println("请输入攻击距离R和三个炮台的坐标x1, y1, x2, y2, x3, y3,"
                +"敌人的坐标x0, y0");
        Integer R=0;
        Integer x1=0;
        Integer y1=0;
        Integer x2=0;
        Integer y2=0;
        Integer x3=0;
        Integer y3=0;
        Integer x0=0;
        Integer y0=0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            R = scanner.nextInt();
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            x3 = scanner.nextInt();
            y3 = scanner.nextInt();
            x0 = scanner.nextInt();
            y0 = scanner.nextInt();
            injure(x1, y1, x0, y0, R);
            injure(x2, y2, x0, y0, R);
            injure(x3, y3, x0, y0, R);
            System.out.println(hurt + "x");
            hurt = 0;
        }
        scanner.close();
    }
    public static int injure(Integer x, Integer y, Integer x0, Integer y0, Integer r) {
        if (Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2)) <= r) {
            hurt++;
        }
        return hurt;
    }
}
