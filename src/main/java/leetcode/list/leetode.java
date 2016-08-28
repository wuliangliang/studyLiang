package leetcode.list;

import clojure.lang.IFn;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * Created by baidu on 16/7/11.
 */
public class leetode {
    ListNode listNode = new ListNode(0);

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = head;
        ListNode l2 = head;
        int length = 0;
        while (l1.next != null) {
            length++;
        }
        for (int i = 0; i < length - n; i++) {
            l1 = l1.next;
        }
        l1.next = l1.next.next;
        l1.next = null;
        return head;
    }

    @Test
    public void test() {
        String str = "[()]";
        System.out.println(isValid(str));
    }

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) return true;
        if (len % 2 != 0) return false;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == '{' && s.charAt(i) == '}') {
                String ss = s.subSequence(0, i - 1).toString() + s.subSequence(i + 1, len).toString();
                return isValid(ss);
            } else if (s.charAt(i - 1) == '[' && s.charAt(i) == ']') {
                String ss = s.subSequence(0, i - 1).toString() + s.subSequence(i + 1, len).toString();
                return isValid(ss);
            } else if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                String ss = s.subSequence(0, i - 1).toString() + s.subSequence(i + 1, len).toString();
                return isValid(ss);
            }
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p,q,r,head;
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        p = l1;
        q = l2;
        head = null;
        if(p.val<=q.val){
            head=p;
            p=p.next;
        }else{
            head=q;
            q = q.next;
        }
        r = head;
        while(p !=null&&q!=null){
            if(p.val<=q.val){
                r.next = p;
                r = p;
                p = p.next;
            }else{
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        if(p == null){
            while(q != null){
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        else{
            while(p != null){
                r.next = p;
                r = p;
                p = p.next;
            }
        }
        return head;

    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            // 匹配needle的字符
            for (int j = 0; ; j++) {
                // 如果needle和j一样长，则直接返回i(当前匹配的起始位置)，因为已经匹配成功了
                if (j == needle.length()) {
                    return i;
                }
                // 如果i+j为当前haystack的长度，则表明已经走完heystack所有的字符，并且没有匹配成功(注意如果最后一个字符正好匹配成功，则在上面一个判断就会返回)
                if (i + j == haystack.length()) {
                    return -1;
                }
                // 如果当前needle和haystack的字符相同的话(因为每次不成功匹配不成功，则i移动1位，而j又重新从0开始，所以haystack的当前位置是i+j)
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        // 当只有一个元素的情况
        if(head.next == null){
            return head;
        }
        ListNode i = head;  // i指向第1个
        ListNode j = i.next;    // j指向第2个
        ListNode k = j.next;    // k指向第3个

        head = head.next;
        while(j != null){
            j.next = i;
            if(k!=null && k.next!=null){    // 当有偶数个节点
                i.next = k.next;
            }else{      // 当有奇数个节点
                i.next = k;
            }

            // 更新i，j，k的值，前进两格
            i = k;
            if(k != null){
                j = k.next;
            }else{
                j = null;
            }
            if(k!=null && k.next!=null){
                k = k.next.next;
            }else{
                k = null;
            }
        }
        return head;
    }


    String countAndSayForOneString(String input) {
        char tmp = input.charAt(0);
        int  num = 1;
        StringBuffer newString = new StringBuffer("");
        for(int k=1;k<input.length();k++) {
            if(input.charAt(k)==tmp) {
                num++;
                continue;
            }
            newString.append(Integer.toString(num) + tmp);
            tmp = input.charAt(k);
            num = 1;
        }
        newString.append(Integer.toString(num) + tmp);
        return newString.toString();
    }

    public String countAndSay(int n) {
        String result = "1";
        int i = 1;
        while(i<n) {
            result = countAndSayForOneString(result);
            i++;
        }
        return result;
    }
    String countAndSayForOneString1(String input){
        char temp = input.charAt(0);
        int num = 1;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 1;i<input.length();i++){
            if(input.charAt(i)==temp){
                num++;
                continue;
            }
            stringBuffer.append(Integer.toString(num)+temp);
            temp = input.charAt(i);
            num=1;
        }
        stringBuffer.append(Integer.toString(num)+temp);
        return stringBuffer.toString();
    }

    public String countAndSay1(int n){
        String result = "1";
        int i= 1;
        while(i<n){
            result = countAndSayForOneString1(result);
            i++;
        }
        return result;
    }

}