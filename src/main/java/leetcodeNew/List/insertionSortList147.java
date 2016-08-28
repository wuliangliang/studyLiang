package leetcodeNew.List;

/**
 * Created by baidu on 16/8/4.
 */
public class insertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pNext = head.next;
        ListNode pNext_Next = null;
        head.next = null;
        while(pNext!=null){
            pNext_Next= pNext.next;
            ListNode temp = head;
            ListNode temp_pre = null;
            while(temp!=null){
                if(temp.val > pNext.val) break;
                temp_pre = temp;
                temp = temp.next;
            }
            if(temp_pre==null){
                head =pNext;
                pNext.next=temp;

            }else{
                temp_pre.next = pNext;
                pNext.next=temp;
            }
            pNext = pNext_Next;

        }
        return head;
    }
}
