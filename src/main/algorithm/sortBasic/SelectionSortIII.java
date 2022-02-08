package sortBasic;

/**
 * @Author zeroback13
 * @Date 2022/1/24 23:11
 * @Version 1.0
 */

/*
    算法思想：同时选出最大最小值，每一轮的处理都面临3个元素找出最大最小值放在right left的位置

 */
public class SelectionSortIII {
    // 我们的算法类不允许产生任何实例
    private SelectionSortIII(){}

    public static void sort(Comparable[] arr){

        int left = 0 , right = arr.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = right;
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0)
                swap( arr , maxIndex , minIndex);
            for(int i = left + 1; i < right;i++){
                if(arr[i].compareTo(arr[minIndex]) < 0)
                    minIndex = i;
                else if (arr[i].compareTo(arr[maxIndex]) > 0)
                    maxIndex = i;
            }
//            swap(arr,minIndex,left);
//            swap(arr,maxIndex,right);
            left ++;
            right --;

        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("sortBasic.SelectionSortIII", arr);
        SortTestHelper.printArray(arr);

        return;
    }
}
