package stack;

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
        System.out.println("Resizing Array to: " + newSize + " current size: " + top);

        T[] newStack = (T[]) new Object[newSize];
        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public static void main(String[] args) throws Exception {
        ResizingArrayStack<Integer> stk = new ResizingArrayStack<Integer>();
        for (int i = 0; i < 4; i++) {
            System.out.println("Currently i = " + i);
            stk.push(i);
        }
        System.out.println("Poped: " + stk.pop());
        System.out.println("Poped: " + stk.pop());
        System.out.println("Poped: " + stk.pop());
        System.out.println("Poped: " + stk.pop());

    }
}
