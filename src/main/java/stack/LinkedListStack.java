package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nbaruah on 12/18/2016.
 */
public class LinkedListStack<T> implements Stack<T> {
    Node<T> first;
    int size;

    public LinkedListStack(){
        first = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.data = item;
        first.next = oldFirst;
        size++;
    }

    public T pop() throws StackUnderFlowException {
        if (size > 0){
            T item = first.data;
            first = first.next;
            size--;
            return item;
        } else {
            throw new StackUnderFlowException("No elements to pop");
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node<D>{
        /*
        Access modifiers doesn't matter,
        because we can access instance variables
        of Node from outer class
        */
        D data;
        Node<D> next;
    }

    private class StackIterator implements Iterator<T> {
        private Node<T> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No next item to return!!");
            T item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }
    }

    public static void main(String[] args) throws Exception {
        Stack stk = new LinkedListStack();
        stk.push(1);
        stk.push(2);
        stk.push(3);

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
