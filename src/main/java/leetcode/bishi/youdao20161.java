package leetcode.bishi;

import java.util.*;

/**
 * Created by baidu on 16/7/21.
 *
 * //思路：开一个map存储字符以及该字符权重，某字符出现在个位权重+1，出现在十位权重+10，以此类推。例子中A=101 B=110 C=11

 //之后map按value从大到小排序，最大为9，次大为8... 结果为 110*9+101*8+11+7

 //考虑开头不为0，当存在0值时，从后往前查询map找到第一个不是头的字符，用0代替，该字符原本代表的数字下移给后一个字符，以此类推。
 */



public class youdao20161 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            char[][] ch = new char[n][];
            Set<Character> set = new HashSet<>();
            for(int i  = 0 ; i < n ; i++){
                ch[i]= scanner.nextLine().toCharArray();
                set.add(ch[i][0]);
            }
            Map<Character, Long> map = new HashMap<>();
            for(int i = 0 ; i < ch.length ; i ++){
                for(int j = 0 ; j < ch[i].length; j ++){
                    if(!map.containsKey(ch[i][j])){
                        map.put(ch[i][j], (long) Math.pow(10,ch[i].length-1-j));
                    }else{
                        map.put(ch[i][j], map.get(ch[i][j])+(long) Math.pow(10,ch[i].length-1-j));
                    }
                }
            }
            List<Map.Entry<Character ,Long>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
                @Override
                public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                    int res = 0;

                    if(o1.getValue() > o2.getValue())

                        res = 1;

                    if(o1.getValue() < o2.getValue())

                        res = -1;

                    return res;
                }
            });

            int num = 9;

            Long res = (long) 0;

            int[] resarray = new int[list.size()];

            for(int i = 0; i < resarray.length; i++) {
                resarray[i] = num--;
            }


        }
    }
}
