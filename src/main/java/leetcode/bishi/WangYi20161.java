package leetcode.bishi;


import java.util.Scanner;

/**
 * Created by baidu on 16/7/18.
 */
public class WangYi20161 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N;
        Integer M;
        Integer K;
        while(scanner.hasNext()){
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();
            if (N < 1 || N > 20)
                return;

            if (M < 1 || M > 20)
                return;

            if (K < 0 || K > 100)
                return;
            Integer[][] NM = new Integer[M+1][N+1];
            int x = 0, y = 0;
            for(int i = 0 ; i < K ; i ++){
                x = scanner.nextInt();
                y = scanner.nextInt();
                NM[y][x]++;
            }
            int max = 0, secondmax = 0;

            max = findMaxIn(NM);
            secondmax = findMaxIn(NM);
            System.out.println(max + secondmax);
        }
    }
    private static int findMaxIn(Integer[][] land) {
        int max = 0;
        int maxX = 0, maxY = 0;
        int num = 0;

        for (int i = 1; i < land.length - 1; i++) {

            for (int j = 1; j < land[0].length - 1; j++) {

                for (int k = i - 1; k <= i + 1; k++) {
                    for (int m = j - 1; m <= j + 1; m++) {
                        if (land[k][m] > 0)
                            num++;
                    }
                }
                if (num > max) {
                    max = num;
                    maxX = j;
                    maxY = i;
                }

                num = 0;
            }
        }
        for (int i = maxY - 1; i <= maxY + 1; i++) {
            for (int j = maxX - 1; j <= maxX + 1; j++) {

                if (land[i][j] > 0)
                    land[i][j] = land[i][j] - 1;
            }
        }

        return max;
    }
}
