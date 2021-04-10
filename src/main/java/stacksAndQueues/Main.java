package stacksAndQueues;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/8 11:14
 */
 
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
