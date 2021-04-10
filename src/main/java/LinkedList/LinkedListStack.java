package LinkedList;

import stacksAndQueues.Stack;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/10 17:36
 */
 
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> satck = new LinkedListStack<Integer>();
        for (int i = 0; i < 5; i++) {
            satck.push(i);
            System.out.println(satck);
        }

        satck.pop();
        System.out.println(satck);
    }
}
