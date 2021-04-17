package LinkedList;

import stacksAndQueues.*;

import java.util.Random;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/10 11:40
 */
 
public class Main {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount );
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount );
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        double time3 = testQueue(linkedListQueue,opCount );
        System.out.println("LinkedListQueue, time: " + time3 + " s");

//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time1 = testStack(arrayStack, opCount);
//        System.out.println("ArrayStack, time: " + time1 +" s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
//        double time2 = testStack(linkedListStack,opCount );
//        System.out.println("LinkedListStack, time: " + time2 + " s");

//        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        for(int i = 0 ; i < 5 ; i ++){
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }

    //测试使用stack 运行opCount个push和pop操作所需要的时间，单位： 秒
    private static double testStack(Stack<Integer> stack ,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> queue ,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
}
