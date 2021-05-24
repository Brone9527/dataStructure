package set;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/15 12:35
 */
 
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
    void remove(E e);
}
