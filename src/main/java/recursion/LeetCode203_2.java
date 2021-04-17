package recursion;

import javax.swing.event.ListDataEvent;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 12:16
 */
 
public class LeetCode203_2 {
    public ListNode removeElements(ListNode head ,int val){
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null)
            return head;
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}
