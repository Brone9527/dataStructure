package LinkedList;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/9 11:34
 */
 
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null,null);
        }

        public Node(E e){
            this(e ,null);
        }

        @Override
        public String toString(){
            return  e.toString();
        }
    }

    private Node dummyNode;
    private int size;

    public LinkedList(){
        dummyNode = new Node();
        size = 0;
    }


}
