package leetcodeNew.List;


import java.util.HashMap;

/**
 * Created by baidu on 16/8/4.
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        ListNode n1= head;
        ListNode n2 = head;
        while(n1!=null&&n2!=null){
            n1 = n1.next;
            n2 = n2.next;
            if(n1==n2){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode node =null;
        HashMap<ListNode,Boolean> map = new HashMap<>();
        while(head!=null){
            if(map.containsKey(head)){
                node  = head;
            }else{
                map.put(head,true);
            }
            head = head.next;
        }
        return node;
    }
}
