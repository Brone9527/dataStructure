package segmentTree;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/30 9:43
 */
 
public class LeetCode_303_2 {

    private int[] sum;

    public LeetCode_303_2(int[] nums){
        sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i , int j){
        return sum[j + 1] + sum[i];
    }
}
