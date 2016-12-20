package queue;

import java.util.NoSuchElementException;

/**
 * Created by nbaruah on 12/20/2016.
 */
public interface Queue<T> {
    /**
     * Insert a new item on the queue
     * @param item
     */
    void enqueue(T item);

    /**
     * Removes the least recently added item
     * @return item
     * @throws NoSuchElementException if the queue is empty
     */
    T dequeue() throws NoSuchElementException;

    /**
     *
     * @return true if the queue is empty otherwise false
     */
    boolean isEmpty();

    /**
     * Number of elements present in the queue
     * @return number of elements
     */
    int size();
}
