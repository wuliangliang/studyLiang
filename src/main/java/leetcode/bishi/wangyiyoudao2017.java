package leetcode.bishi;

import java.util.Scanner;

/**
 * Created by baidu on 16/8/22.
 */
public class wangyiyoudao2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[2*n];
            for(int j = 0; j < 2*n ; j ++){
                    a[j] = scanner.nextInt();
            }
            for(int l = 0 ; l < k ; k++){
                a=sort(a);
            }
            StringBuilder str =new StringBuilder();
            for(int p = 0 ; p< 2*n;p++){
                str.append(String.valueOf(a[p]));
                str.append(" ");
            }
            System.out.println(str.deleteCharAt(str.length()-1).toString());
        }
    }
    public static int[] sort(int[] a){
        int[] b = new int[a.length];
        int x = a.length-1;
        int n = a.length/2;
        for(int y = n-1 ;y>0;y--){
            b[x]=a[y+n];
            b[--x]=a[y];
            x--;
        }
        return b;
    }
}
