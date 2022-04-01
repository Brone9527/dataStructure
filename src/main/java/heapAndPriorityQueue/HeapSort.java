package heapAndPriorityQueue;

import sortBasic.SortTestHelper;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2022/4/1 18:25
 */

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {
    // 我们的算法类不允许产生任何实例
    private HeapSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for(int count = (n-1-1)/2;count >= 0;count--){
            shiftDown(arr,n,count);
        }

        //将堆顶元素与末尾元素进行交换，使末尾元素最大。
        // 然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。
        // 如此反复进行交换、重建、交换。
        for (int i = n-1; i >= 0 ; i--) {
            swap(arr,i,0);
            shiftDown(arr, i, 0);

        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr,int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    public static void shiftDown(Comparable[] arr,int n, int k){
        Comparable e = arr[k];
        while (2*k+1 < n){
            int j = 2*k + 1;
            if(j+1 < n && arr[j].compareTo(arr[j+1]) < 0)
                j++;
            if(e.compareTo(arr[j]) >= 0) break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("heapAndPriorityQueue.HeapSort", arr);

        return;

    }
}
