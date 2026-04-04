package structures.queues;

import structures.exceptions.QueueException;

public class QueueLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() throws QueueException {
        if (head == null) throw new QueueException("queue is empty");

        T data = head.data;
        head = head.next;
        size--;

        if (head == null) tail = null;

        return data;
    }

    public T peek() throws QueueException {
        if (head == null) throw new QueueException("queue is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
