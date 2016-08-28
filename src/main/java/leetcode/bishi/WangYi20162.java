package leetcode.bishi;

import java.util.Scanner;

/**
 * Created by baidu on 16/7/18.
 */
public class WangYi20162 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Integer monsterCount = scanner.nextInt();
            Integer initialPower = scanner.nextInt();
            Integer currentPower = initialPower;
            for(int i  =0  ; i<monsterCount;i++){
                Integer defensivePower = scanner.nextInt();
                if (defensivePower <= currentPower) {
                    currentPower += defensivePower;
                }else {
                    currentPower += WangYi20162.getGreatestCommonDivisor(currentPower, defensivePower);
                }
            }
            System.out.println(currentPower);
        }
        scanner.close();
    }
    public static Integer getGreatestCommonDivisor(Integer firstNum, Integer secondNum){
        if (firstNum < secondNum) {
            int temp;
            temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }
        if (0 == secondNum) {
            return firstNum;
        }
        return WangYi20162.getGreatestCommonDivisor(secondNum, firstNum % secondNum);
    }
}
