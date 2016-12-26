package queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by nbaruah on 12/23/2016.
 */
public class ResizingCircularArrayQueue<T> implements Queue<T> {
    private static final int INITIAL_CAPACITY = 2;

    private int n; // Number of elements in the queue
    private T[] q; // The queue
    private int front; // Index of next element to dequeue
    private int rear;  // Index of next free slot to enqueue an element

    // Initializing an empty Queue with initial capacity
    ResizingCircularArrayQueue(){
        q = (T[]) new Object[INITIAL_CAPACITY];
        n = 0;
        front = rear = 0;
    }

    /**
     * Rearranges the Queue array with new size.
     * @param newCapacity
     */
    private void resize(int newCapacity){
        if (newCapacity < n) throw new IllegalArgumentException("New capacity cannot be less than the number of elements");
        T[] newQ = (T[]) new Object[newCapacity];
        for (int i = 0; i < n; i++) {
            newQ[i] = q[(front + i) % q.length];
        }
        q = newQ;
        front = 0;
        rear = n;
    }

    /**
     * Adds an element to the end of the Queue.
     * Wraps around if there are free slots in the underlying array.
     * @param item
     */
    public void enqueue(T item) {
        if (n == q.length) resize(2 * q.length);
        q[rear++] = item;
        if (rear == q.length) rear = 0; // Wraps around if the Queue is not full.
        n++;
    }

    /**
     * Removes element at the front of the Queue.
     * Shrinks the size of underlying Array to half,
     * if number of elements in the Queue is 1/4 of size of the Array.
     *
     * @return Item at the front
     * @throws NoSuchElementException
     */
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!!");
        T item = q[front]; // Item to be deleted from queue
        q[front] = null;   // To avoid loitering
        n--;
        front++;
        if (front == q.length) front = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    /**
     * Is the Queue empty.
     * @return true if the Queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * The number of elements currently present in the Queue.
     * @return number of elements.
     */
    public int size() {
        return n;
    }

    public static void main(String[] args){
        ResizingCircularArrayQueue<String> queue = new ResizingCircularArrayQueue<String>();
        System.out.println(Arrays.toString(queue.q));
        queue.enqueue("Nayan");
        queue.enqueue("Mani");
        queue.dequeue();
        queue.enqueue("Baruah");
        System.out.println(Arrays.toString(queue.q));
        System.out.println("Front: " + queue.front);
        System.out.println("Last: " + queue.rear);
        queue.enqueue("Jamuna");
        System.out.println(Arrays.toString(queue.q));
        System.out.println("Front: " + queue.front);
        System.out.println("Last: " + queue.rear);
    }
}
