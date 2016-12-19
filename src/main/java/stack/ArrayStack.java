package stack;

/**
 * This class represents fixed capacity Stack. It is implemented using Array
 * Created by nbaruah on 12/18/2016.
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] stack;

    public ArrayStack(int capacity){
        stack = (T[]) new Object[capacity];
    }
    public void push(T item) {

    }

    public T pop() throws StackUnderFlowException {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}
