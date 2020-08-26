package 排序链表;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
     int val;
    ListNode next;
     ListNode(int x) {
         val = x;
     }
}
public class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }
        Collections.sort(l);
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        for(int each:l){
            ListNode temp = new ListNode(each);
            dummy.next = temp;
            dummy = dummy.next;
        }
        return  res.next;

    }
}
