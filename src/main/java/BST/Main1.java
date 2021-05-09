package BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/9 14:09
 */
 
public class Main1 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        Random random = new Random();

        int n = 1000;
        //test removeMin
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        }
        System.out.println("removeMin test completed");

        //test removeMax
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
            nums = new ArrayList<>();

            while (!bst.isEmpty()){
                nums.add(bst.removeMax());
            }
            System.out.println(nums);
            for (int j = 1; j < nums.size(); j++) {
                if (nums.get(j-1) < nums.get(j))
                    throw new IllegalArgumentException("Error!");
            }
            System.out.println("removeMax test completed");

    }
}
