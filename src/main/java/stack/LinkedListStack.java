package stack;

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
        first = new Node<T>(item);
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
        return false;
    }

    public int size() {
        return 0;
    }

    private class Node<D>{
        /*
        Access modifiers doesn't matter,
        because we can access instance variables
        of Node from outer class
        */
        D data;
        Node<D> next;

        public Node(D data){
            this.data =  data;
            next = null;
        }
    }

    public static void main(String[] args) throws StackUnderFlowException {
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
