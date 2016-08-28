package leetcode.list;

/**
 * Created by baidu on 16/8/9.
 */
public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        ListNode curr1=dummy1;
        ListNode curr2=dummy2;
        while(head!=null){
            if(head.val<x){
                curr1.next=head;
                curr1=curr1.next;
            }else{
                curr2.next=head;
                curr2=curr2.next;
            }
            head=head.next;
        }
        curr2.next=null;//这句很重要！链表最后一个元素如果小于x的话，那么curr2.next
        //不为null
        curr1.next=dummy2.next;
        return dummy1.next;
    }
}
