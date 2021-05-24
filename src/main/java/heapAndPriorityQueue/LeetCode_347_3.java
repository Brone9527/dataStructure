package heapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/22 13:48
 */
 
public class LeetCode_347_3 {

    private class Freq {

        public int e, freq;
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

    }

    public class FreqComparator implements Comparator<Freq>{
        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
        for (int key: map.keySet()) {
            if (pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        //LinkedList<Integer> res = new LinkedList<>();
//        while (!pq.isEmpty()){
//            res.add(pq.dequeue().e);
//        }
        int[] res  = new int[pq.size()];
        System.out.println("优先队列大小"+pq.size());

        for (int  i = 0 ; i < k; i++) {
            res[i] = pq.remove().e;
        }
        return res;
    }

    private static void printList(int[] nums){
        for (Integer num :nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList(new LeetCode_347_3().topKFrequent(nums,k ));
    }
}
