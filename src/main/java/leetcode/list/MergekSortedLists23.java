package leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by baidu on 16/8/17.
 */
/*

23. Merge k Sorted Lists
Total Accepted: 98174
Total Submissions: 401492
Difficulty: Hard
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems

 */
public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(16,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;
        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            //上面的offer入队,只是入队第一个元素,
            if(n.next!=null)
                queue.offer(n.next);
        }
        return head.next;
    }

}
