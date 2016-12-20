package stack;

/**
 * This class represents fixed capacity Stack. It is implemented using Array
 * Created by nbaruah on 12/18/2016.
 */
public class StaticArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    public StaticArrayStack(int capacity){
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        top=0;
    }
    public void push(T item) {
        if (top == capacity){
            throw new ArrayIndexOutOfBoundsException("Stack is full!!");
        } else {
            stack[top++] = item;
        }
    }

    public T pop() throws StackUnderFlowException {
        if(top == 0){
            throw new StackUnderFlowException("No items to pop!!!");
        }else {
            T item = stack[--top];
            return item;
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public static void main(String[] args) throws Exception{
        StaticArrayStack<String> stack = new StaticArrayStack<String>(3);
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        //stack.pop();
        stack.push("Nayan");
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        stack.push("Mani");
        stack.push("Baruah");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
