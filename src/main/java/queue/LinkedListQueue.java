package queue;

import java.util.NoSuchElementException;

/**
 * Implements a Queue (First in first out policy)
 * Created by nbaruah on 12/20/2016.
 */
public class LinkedListQueue<T> implements Queue<T> {
    private Node front;
    private Node end;
    private int size;

    LinkedListQueue(){
        front = end = null;
        size = 0;
    }

    /**
     * The enqueue operation is similar to insertion at the end of a Linked list.
     * @param item
     */
    public void enqueue(T item) {
        Node oldEnd = end;
        end = new Node(item);
        //special case when the queue is empty
        if (isEmpty()) front = end;
        else           oldEnd.next = end;
        size++;
    }

    /**
     * The Dequeue operation is similar to deletion front of a linked list.
     * @return
     * @throws NoSuchElementException
     */
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!!");
        T item = front.data;
        front = front.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    /**
     * Helper class to represent a Node in the Linked list.
     */
    private class Node {
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){
        LinkedListQueue<String> queue = new LinkedListQueue<String>();
        queue.enqueue("Nayan");
        queue.enqueue("Mani");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("Baruah");
        System.out.println(queue.dequeue());
    }
}
