package BST;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/9 11:07
 */
 
public class Main {
    public static void main(String[] args) {
        BST_Improved<Integer> bst = new BST_Improved<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2, };
        for (int num: nums) {
           bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        //System.out.println(bst);

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}
