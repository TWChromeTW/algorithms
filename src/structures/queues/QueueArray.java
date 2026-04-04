package structures.queues;

import structures.exceptions.QueueException;

public class QueueArray<T> {

    private T[] array;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public QueueArray() {
        this.array = (T[]) new Object[10];
        this.size = 0;
        this.capacity = 10;
        this.head = 0;
        this.tail = 0;
    }

    public QueueArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(T item) throws QueueException {
        if (size == capacity) throw new QueueException("queue is overflow");
        array[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    public T dequeue() throws QueueException {
        if (size == 0) throw new QueueException("queue underflow");
        T item = array[head];
        array[head++] = null;
        head = (head + 1) % capacity;
        size--;

        return item;
    }

    public T peek() throws QueueException {
        if (size == 0) throw new QueueException("queue underflow");
        return array[head];
    }

}
