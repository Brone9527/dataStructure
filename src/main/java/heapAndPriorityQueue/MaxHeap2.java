package heapAndPriorityQueue;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2022/4/1 14:29
 */


// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap2 <Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;


    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap2(int capacity){
        data = (Item[])new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;

    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap2(Item arr[]){

        int n = arr.length;
        data = (Item[]) new Comparable[capacity + 1];
        count = n;
        for(int i = 0;i < n; i++){
            data[i+1] = arr[i];
        }

        for(int i = count/2;i >= 1;i++)
            shiftDown(i);

    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }
    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){
        assert count+1 <= capacity;
        data[count+1] = item;
        count++;
        shiftUp(count);

    }
    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item ret = data[1];
        swap(1,count );
        count--;
        shiftDown(1);
        return ret;
    }


    //********************
    //* 最大堆核心辅助函数
    //********************
    public void shiftDown(int k){
        while(2*k < count){
            int j = 2*k;
            if(j+1 <= count && data[j+1].compareTo(data[j]) > 0)
                j++;
            if(data[k].compareTo(data[j]) > 0) break;
            swap(j,k);
            k = j;
        }

    }
    public void shiftUp(int k){
        while (k > 1 && data[k/2].compareTo(data[k]) < 0){
            swap(k,k/2 );
            k = k/2;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {
       MaxHeap2<Integer> maxHeap2 = new MaxHeap2<>(100);
       int N = 10; // 堆中元素个数
       int M = 100; // 堆中元素取值范围[0, M)
       for (int i = 0; i < N; i++) {
            maxHeap2.insert(new Integer((int)(Math.random()*M)));
       }
        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap2.extractMax();
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++) {
           assert arr[i -1] <= arr[i];
        }
    }

}
