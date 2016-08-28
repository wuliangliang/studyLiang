package leetcode.list;

/**
 * Created by doubling on 16/7/30.
 */
public class StackOfIntegers {
    //存放分解的素数
    /**
     * 求最小质因数
     */
    public static int t = 0;
    public static int minPrimeYinShu(int n){
        t++;
        //判断是否为质数
        if(isPrime(n)){
            return n;
        }

        //获取n的开方,并取整
        Double d = new Double(Math.sqrt(n));
        int m = d.intValue();

        //如果这里m为质数,并且能被n整除
        if(isPrime(m) && n%m==0){
            int temp = n/m;

            //这里temp一定会比m大
            if(StackOfIntegers.isPrime(temp)){
                return m;//递归出口！
            }else {
                return minPrimeYinShu(temp);
            }
        }
        //直到m能被整除
        while(n%m!=0){
            //	whilekey++;
            m--;
        }
        if(isPrime(m) && n%m==0){
            int temp = n/m;
            //这里temp一定会比m大
            if(StackOfIntegers.isPrime(temp)){
                return m;//递归出口！
            }else {
                return minPrimeYinShu(temp);
            }
        }

        return minPrimeYinShu(m);
    }
    /**
     * 判断是否为素数
     * @param n 待判断整数
     * @return 布尔类型
     */
    public static boolean isPrime(int n){
        if(2 > n){
            return false;
        }
        boolean isPrime = true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if((0==n%i) || (n<2)){
                isPrime = false;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackOfIntegers s = new StackOfIntegers();

        System.out.println(s.minPrimeYinShu(9));
    }

}
