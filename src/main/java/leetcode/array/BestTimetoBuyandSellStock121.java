package leetcode.array;

/**
 * Created by doubling on 16/8/6.
 */
public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0 ; i<prices.length-1;i++){
            for(int j = i+1 ; j<prices.length;j++){
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }
    public int maxProfit1(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int profile =  0 ;
        int min = prices[0];
        int len = prices.length;
        for(int i= 1 ; i < len;i++){
            min = Math.min(min,prices[i-1]);
            profile = Math.max(prices[i]-min,profile);
        }
        return profile;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length==0)
            return 0;
        int len=prices.length,profit=0;
        for(int i=0;i<len-1;i++){
            if(prices[i+1]>prices[i])
                profit+=prices[i+1]-prices[i];
        }
        return profit;
    }

}