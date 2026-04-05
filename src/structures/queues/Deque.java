package structures.queues;

import structures.exceptions.QueueException;

public class Deque<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");

        T value = head.value;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;

        return value;
    }

    public T removeLast() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");

        T value = tail.value;
        if (head == tail) {
            tail = head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;

        return value;
    }

    public void reverse() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");

        Node<T> current = head;
        Node<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public T peekFirst() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");
        return head.value;
    }

    public T peekLast() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");
        return tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void show() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
