package structures.lists;

import structures.exceptions.ListException;

public class List<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void insertLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void insertPos(T value, int index) throws ListException {
        if (index < 0 || index > size) throw new ListException("index out of range");
        if (index == 0) {
            insertFirst(value);
        }
        else if (index == size) {
            insertLast(value);
        }
        else {
            Node<T> newNode = new Node<>(value);
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public boolean search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (value.equals(current.value)) return true;
            current = current.next;
        }
        return false;
    }

    public T getElement(int index) throws ListException {
        if (index < 0 || index > size) throw new ListException("index out of range");
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public boolean delete(T value) throws ListException {
        if (isEmpty()) throw new ListException("list is empty");
        if (head.value.equals(value)) {
            head = head.next;
            if (head == null) tail = null;
            size --;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
