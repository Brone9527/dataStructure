package recursion;

import java.sql.SQLOutput;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 12:16
 */

//递归法删除，，，，加上输出，，直观显示递归调用过程
public class LeetCode203_6 {
    public ListNode removeElements(ListNode head ,int val , int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+ val + " in " +head);
        if(head ==null){
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return head;
        }
        //大问题拆分为更小一级的问题
        ListNode res = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After Remove: " + val+": " +res);
        //利用递归拆分更小的求解结果组合大问题的结果
        ListNode ret;
        if(head.val == val){  //若头结点是待删除的节点，则直接返回小问题的结果
            ret = res;
        }else {
            head.next = res;//若头结点不需要删除，则将小问题的结果拼接到头结点后
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return :" +ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LeetCode203_6()).removeElements(head, 6,0);
        System.out.println(res);
    }
}
