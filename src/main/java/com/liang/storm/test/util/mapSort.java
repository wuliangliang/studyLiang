package com.liang.storm.test.util;

import java.util.*;

/**
 * Created by liang on 16/5/12.
 */
public class mapSort {
    public static Map<String ,Integer> sort(Map<String ,Integer> map)
    {
        if(map==null)
            return null;
        List list = new LinkedList(map.entrySet());
        Map<String ,Integer> newMap = new LinkedHashMap<String, Integer>();
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Comparable c1= (Comparable) ((Map.Entry)o1).getValue();
                Comparable c2= (Comparable) ((Map.Entry)o2).getValue();

                return c2.compareTo(c1);
            }
        });

        for(Iterator it =list.iterator();it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            newMap .put((String)entry.getKey(),(Integer)entry.getValue());
        }

        return newMap;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer> ();
        map.put("test", 3);
        map.put("hcy", 1);
        map.put("put", 2);

        map = sort(map);

        for (String key : map.keySet()) {
            System.out.println( key + " ==> " + map.get(key));
        }
    }
}
