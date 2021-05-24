package map;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/15 19:18
 */
 
public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for (int num : nums1){
            if (!map.containsKey(num))
                map.put(num,1 );
            else
                map.put(num,map.get(num)+1 );
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2){
            if (map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) -1 );
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }
        int[] ret = new int[list.size()];
        for (int i= 0;i<list.size();i++)
            ret[i] = list.get(i);
        return ret;
    }
}
