package sortAdvance;

import array.Array;
import sortBasic.SortTestHelper;

import java.util.Arrays;

/**
 * @Author zeroback13
 * @Date 2022/2/8 19:56
 * @Version 1.0
 */
public class MergeSort {

    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (r + l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else //(aux[i -l].compareTo(aux[j - l]) > 0)
            {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

        public static void main (String[] args){
            //Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
            // 可以在1秒之内轻松处理100万数量级的数据
            // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
            // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.testSort("sortAdvance.MergeSort", arr);

            return;
        }


}
