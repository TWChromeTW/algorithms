package structures.stacks;

import structures.exceptions.StackException;

public class StackLinkedList<T> {

    private static class Node<E> {
        final E val;
        Node next;

        Node(E val) {
            this.val = val;
        }
    }

    private Node<T> head;
    private long size = 0;


    public void push(T val) {
        Node<T> newNode = new Node<T>(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() throws StackException {
        if (head == null) throw new StackException("Stack underflow");
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.val;
    }

    public T peek() throws StackException {
        if (head == null) throw new StackException("Empty stack");
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
