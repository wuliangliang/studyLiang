package leetcode.bishi.美团;

/**
 * Created by baidu on 16/8/25.
 */
public class m201604 {
    /*
    题目描述

    现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，
    但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
    给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，
    请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
    测试样例：
    [[0,1,0],[2,0,0]],2,3
    返回：2
     */
    public int countPath(int[][] map, int n, int m) {
        // write code here
        int startX = 0 ;
        int startY = 0 ;
        int endX = 0 ;
        int endY = 0 ;
        int[][] plan = new int[n][m]; //走到当前点的方案数


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(map[i][j] == 1){
                    startX = i ;
                    startY = j ;
                }
                if(map[i][j] == 2){
                    endX = i ;
                    endY = j ;
                }
            }
        }

        int dirX = startX > endX ? -1 : 1;       //确定沿X、Y的移动方向!
        int dirY = startY > endY ? -1 : 1;

        for(int i  = startX;i!=endX+dirX;i+=dirX){
            for(int j = startY;j!=endY+dirY;j+=dirY){
                if(i==startX&&j == startY){

                }
            }
        }
        return 0;
    }

    public int countPath1(int[][] map , int n , int m ){
        int x1 = -1 , y1 = -1;
        int x2 = -2 , y2 = -1;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j]==1){
                    x1 = j;
                    y1 = i;
                }else if(map[i][j]==2){
                    x2 = j;
                    y2 = i;
                }
            }
        }
        int xto = x1>x2?-1:1;
        int yto = y1>y2?-1:1;

        for(int y = y1 ; y!=y2+yto;y+=yto){
            for(int x = x1 ; x!=x2+xto;x+=xto){
                if(y == y1|| x == x1){
                    map[y][x]=1;
                    break;
                }
                map[y][x] = map[y-yto][x]+map[y][x-xto];
            }
        }
        return map[y2][x2];
    }
}
