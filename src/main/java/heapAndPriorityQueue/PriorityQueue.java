package heapAndPriorityQueue;

import stacksAndQueues.Queue;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/22 12:00
 */
 
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap = new MaxHeap<E>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }


    @Override
    public E dequeue() {
        return maxHeap.extracrtMax();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

}
