package stack;

/**
 * The interface represents a stack API
 *
 * Created by nbaruah on 12/18/2016.
 */
public interface Stack<T> {
    /**
     * Inserts an item into the Stack
     * @param item
     */
    void push(T item);

    /**
     * Returns the most recently added item
     * @return Recently added Item
     */
    T pop() throws StackUnderFlowException;

    /**
     * Tells if the Stack empty
     * @return true if Stack is empty otherwise false
     */
    boolean isEmpty();

    /**
     * Returns the current number of items in the Stack
     * @return Current number of items
     */
    int size();
}
