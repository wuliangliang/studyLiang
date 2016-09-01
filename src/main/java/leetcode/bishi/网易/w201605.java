package leetcode.bishi.网易;

import java.util.Scanner;

/**
 * Created by doubling on 16/8/28.
 */
public class w201605 {
    /*
    [编程题] 藏宝图
    牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
    输入描述:
    每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。


    输出描述:
    输出一行 “Yes” 或者 “No” 表示结果。

    输入例子:
    x.nowcoder.com
    ooo

    输出例子:
    Yes
    * */
    public static final void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            boolean result=isContain(str1,str2);
            if(result){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        scan.close();
    }

    public static boolean isContain(String str1,String str2){
        for(int i=0,index=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(index)){
                index++;
                if(index==str2.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
