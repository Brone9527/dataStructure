package LinkedList;

import stacksAndQueues.ArrayStack;
import stacksAndQueues.Stack;

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
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 +" s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        double time2 = testStack(linkedListStack,opCount );
        System.out.println("LinkedListStack, time: " + time2 + " s");

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
}
