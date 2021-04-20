package recursion;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 12:16
 */

//递归法删除,代码优化
public class LeetCode203_5 {
    public ListNode removeElements(ListNode head ,int val) {
        if(head ==null){
            return head;
        }
        //大问题拆分为更小一级的问题
        head.next = removeElements(head.next,val);
        //利用递归拆分更小的求解结果组合大问题的结果
        //若头结点是待删除的节点，则直接返回小问题的结果
       //若头结点不需要删除，则将小问题的结果拼接到头结点后
        return head.val == val ? head.next:head;

    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCode203_5()).removeElements(head, 6);
        System.out.println(res);
    }
}
