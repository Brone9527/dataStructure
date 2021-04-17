package recursion;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 12:16
 */

//带有虚拟头节点的链表
public class LeetCode203_3 {
    public ListNode removeElements(ListNode head ,int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }

        return dummyHead.next;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCode203_3()).removeElements(head, 6);
        System.out.println(res);
    }
}
