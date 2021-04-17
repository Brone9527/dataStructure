package recursion;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 12:16
 */

//递归法删除
public class LeetCode203_4 {
    public ListNode removeElements(ListNode head ,int val) {
        return null;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCode203_4()).removeElements(head, 6);
        System.out.println(res);
    }
}
