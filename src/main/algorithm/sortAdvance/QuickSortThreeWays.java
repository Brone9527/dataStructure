package sortAdvance;

import sortBasic.InsertionSort;
import sortBasic.SortTestHelper;

/**
 * @Author zeroback13
 * @Date 2022/2/9 22:36
 * @Version 1.0
 */
public class QuickSortThreeWays {
    // 我们的算法类不允许产生任何实例
    private QuickSortThreeWays(){}

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        //随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        Comparable v = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while(i < gt){
            if(arr[i].compareTo(v) < 0){
                swap(arr,lt + 1,i);
                lt ++;
                i ++;
            }else if(arr[i].compareTo(v) > 0){
                swap(arr,gt - 1,i);
                gt --;

            }else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort(arr, l, lt-1 );
        sort(arr, gt, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sortAdvance.QuickSortThreeWays", arr);

        return;
    }
}