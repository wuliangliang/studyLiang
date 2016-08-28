package com.liang.a;

import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int map[][] = new int[100][100];
    public static int sumsum[][] = new int[100][100];
    public static int ci[] = new int[5];
    public static int cj[] = new int[5];
    public static int max = 0;
    public static int getValue(int i, int j){
        int si = 0;
        if(i >= 1)
            si = ci[i-1];
        int li = n;
        if(i <= 2)
            li = ci[i];
        int sj = 0;
        if(j >= 1)
            sj = cj[j-1];
        int lj = m;
        if(j <= 2)
            lj = cj[j];
        return sumsum[si][sj] - sumsum[li][sj] - sumsum[si][lj] + sumsum[li][lj];

    }
    public static int getMin(){
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < 4;i ++)
            for(int j = 0; j < 4; j++)
            {
                int  t= getValue(i, j);
                if(t < min)
                    min = t;
            }
        return min;

    }
    public static void search(int i, int j, int a, int b){
        if(a == 3 && b == 3){
            int  t = getMin();
            if(t > max)
                max = t;
            return;
        }
        if(a == 3){
            for(int k = j + 1; k < m; k++) {
                cj[b] = k;
                search(i, k, a, b + 1);
            }
        } else {
            for(int k = i + 1; k < n; k++) {
                ci[a] = k;
                search(k, j, a + 1, b);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < sumsum.length; i++)
            for(int j = 0; j < sumsum[i].length; j++)
                sumsum[i][j] = 0;

        for(int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for(int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
        }
        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--)
                sumsum[i][j] = sumsum[i + 1][j] + sumsum[i][j + 1] + map[i][j] - sumsum[i + 1][j + 1];
        search(0, 0, 0, 0);
        System.out.println(max);
        scanner.close();
    }

}