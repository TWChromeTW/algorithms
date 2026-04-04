package structures.queues;

import structures.exceptions.QueueException;
import structures.exceptions.StackException;
import structures.stacks.StackLinkedList;


public class QueueTwoStack<T> {

    private StackLinkedList<T> stackIn;
    private StackLinkedList<T> stackOut;

    public QueueTwoStack() {
        stackIn = new StackLinkedList<>();
        stackOut = new StackLinkedList<>();
    }

    public void enqueue(T value) {
        stackIn.push(value);
    }

    public T dequeue() throws StackException, QueueException {
        if (isEmpty()) throw new QueueException("Empty queue");
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public T peek() throws StackException, QueueException {
        if (isEmpty()) throw new QueueException("Empty queue");
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

}
