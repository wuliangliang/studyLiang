package leetcode.bishi.美团;

/**
 * Created by baidu on 16/8/25.
 */
public class m201605 {

    /*
    题目描述

    有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
    给定数组A及它的大小n，请返回最大差值。
    测试样例：
    [10,5],2
    返回：0
     */
    public int getDis(int[] A, int n) {
        // write code here
        int dist = 0 ;
        if(n>1){
            int min  = A[0];
            for(int i = 1 ; i < n ; i++){
                if(A[i]-min>dist){
                    dist=A[i]-min;
                }
                if(min>A[i]){
                    min = A[i];
                }
            }
        }
        return dist;
    }
}
