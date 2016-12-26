package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nbaruah on 12/20/2016.
 */
public class ResizingArrayStack<T> implements Stack<T>{
    private T[] stack;
    private int top;
    private int capacity;

    public ResizingArrayStack(){
        top = 0;
        capacity = 1;
        stack =  (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (top == capacity){
            capacity = capacity * 2;
            resize(capacity);
        }
        stack[top++] = item;
    }

    public T pop() throws StackUnderFlowException {
        if (top == 0){
            throw new StackUnderFlowException("No items to pop!!");
        }
        T item = stack[--top];
        stack[top] = null;
        if (top > 0 && top == capacity/4){
            resize(capacity = capacity/2);
        }
        return item;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    private void resize(int newSize){
        T[] newStack = (T[]) new Object[newSize];

        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int i = top-1;

        public boolean hasNext() {
            return i >= 0;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = stack[i--];
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) throws Exception {
        ResizingArrayStack<Integer> stk = new ResizingArrayStack<Integer>();
        for (int i = 0; i < 4; i++) {
            stk.push(i);
        }

        for (Integer n : stk){
            System.out.println(n);
        }
    }
}
