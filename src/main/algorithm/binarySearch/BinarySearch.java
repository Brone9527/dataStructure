package binarySearch;

/**
 * @Author zeroback13
 * @Date 2022/1/9 12:33
 * @Version 1.0
 */
public class BinarySearch {


    public static int binarySearch(Comparable[] arr,int n,Comparable target){

        int l = 0, r = n - 1;//在[l ... r]范围里寻找target

        while (l <= r){   //当l == r 时 [ l ... r] 依然是有效的
            int mid = l + (r - l)/2;
            if (arr[mid].compareTo(target) == 0)
                return mid;
            else if(arr[mid].compareTo(target) < 0)
                l = mid + 1;  // target在[mid+1...r]中; [l...mid]一定没有target
            else
                r = mid - 1;   // target在[l...mid-1]中; [mid...r]一定没有target
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = (int) Math.pow(10,6);
        System.out.println("随机生成的n：  " + n);

        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0;i < n; i++){
            if( i != binarySearch(data,n,i))
                throw new IllegalStateException("find i failed!");
        }
        long endTime = System.currentTimeMillis();


        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
