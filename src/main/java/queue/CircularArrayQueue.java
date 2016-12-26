package queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class implements a circular Queue or Buffer with a fixed capacity defined ahead.
 * Created by nbaruah on 12/21/2016.
 */
public class CircularArrayQueue<T> implements Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int capacity;

    CircularArrayQueue(int capacity){
        queue = (T[]) new Object[capacity];
        front = rear = 0;
        this.capacity = capacity;
    }

    public void enqueue(T item) {
        int newRear = (rear + 1) % capacity;
        if ( newRear == front){
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        } else {
            queue[rear] = item;
            rear = newRear;
        }
    }

    public T dequeue() throws NoSuchElementException {
        if (front == rear){
            throw new NoSuchElementException("Queue is empty!!");
        } else {
            T item = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity;
            return item;
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return capacity - Math.abs(rear - front);
    }

    public static void main(String[] args){
        CircularArrayQueue<String> circularBuffer = new CircularArrayQueue<String>(5);
        circularBuffer.enqueue("IP packet 1");
        circularBuffer.enqueue("IP packet 2");
        circularBuffer.enqueue("IP packet 3");
        circularBuffer.enqueue("IP packet 4");
        System.out.println(circularBuffer.dequeue());
        circularBuffer.enqueue("IP packet 5");
        System.out.println(circularBuffer.size());
        System.out.println(Arrays.toString(circularBuffer.queue) + "\nfront: " + circularBuffer.front + "\nrear: " + circularBuffer.rear);
        System.exit(0);


        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        circularBuffer.enqueue("IP packet 6");
        circularBuffer.enqueue("IP packet 7");
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        circularBuffer.enqueue("IP packet 8");
        circularBuffer.enqueue("IP packet 9");
        circularBuffer.enqueue("IP packet 10");
        circularBuffer.enqueue("IP packet 11");
        System.out.println(Arrays.toString(circularBuffer.queue) + "\nfront: " + circularBuffer.front + "\nrear: " + circularBuffer.rear);
    }
}
