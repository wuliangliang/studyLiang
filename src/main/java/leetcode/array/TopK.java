package leetcode.array;

import java.util.*;

/**
 * Created by baidu on 16/7/12.
 */

//特别好的题目,使用了很多集合特性
public class TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,FEntity> map = new HashMap<Integer,FEntity>();
        //统计各数字出现的次数 存入hashmap
        for(int t:nums){
            FEntity f;
            if(map.containsKey(t)){
                f = map.get(t);
                f.frequent++;
            }else{
                f = new FEntity(t, 1);
            }
            map.put(t, f);
        }
        List<FEntity> values = new ArrayList<FEntity>();
        Set<Integer> keys = map.keySet();
        for(Integer key:keys){
            values.add(map.get(key));
        }
        Collections.sort(values);
        for(int i=0;i<k;i++){
            res.add(values.get(values.size()-1-i).num);
        }
        return res;
    }

}

class FEntity implements Comparable<FEntity> {
    int num, frequent;

    public FEntity(int num, int frequent) {
        this.num = num;
        this.frequent = frequent;
    }

    public int compareTo(FEntity arg0) {
        if (frequent > arg0.frequent)
            return 1;
        else if (frequent == arg0.frequent)
            return 0;
        else
            return -1;
    }
}