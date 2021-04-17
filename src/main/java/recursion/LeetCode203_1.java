package recursion;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 10:57
 */
 
public class LeetCode203_1 {

    public ListNode removeElements(ListNode head ,int val){
        while (head != null && head.val == val){
           ListNode delNode = head;
           head = head.next;
           delNode.next = null;
        }
        if(head == null)
            return head;
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4 , 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCode203_1().removeElements(head,6 ));
        System.out.println(res);
    }

}
