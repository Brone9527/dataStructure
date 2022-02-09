package sortAdvance;

import sortBasic.SortTestHelper;

import java.util.Arrays;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2022/2/9 9:28
 */
 
public class Main {
    public static void main(String[] args) {
        int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sortAdvance.MergeSort", arr1);
        SortTestHelper.testSort("sortAdvance.MergeSortI", arr3);
        SortTestHelper.testSort("sortAdvance.MergeSortII", arr4);
        SortTestHelper.testSort("sortAdvance.MergeSortBU", arr2);
        //SortTestHelper.testSort("sortBasic.InsertionSort", arr2);

        // 测试2 测试近乎有序的数组
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderArray(N,swapTimes );
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length );
        arr4 = Arrays.copyOf(arr1, arr1.length );

        SortTestHelper.testSort("sortAdvance.MergeSort", arr1);
        SortTestHelper.testSort("sortAdvance.MergeSortI", arr3);
        SortTestHelper.testSort("sortAdvance.MergeSortII", arr4);
        SortTestHelper.testSort("sortAdvance.MergeSortBU", arr2);
        //SortTestHelper.testSort("sortBasic.InsertionSort", arr2);

    }
}
