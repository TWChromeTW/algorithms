package structures.lists;

import structures.exceptions.ListException;

public class ListDoubleLinked<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListDoubleLinked() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
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
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void add(int index, T value) throws ListException {
        if (index < 0 || index > size) throw new ListException("index out of range");

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<T> current;

            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) current = current.prev;
            }

            Node<T> newNode = new Node<>(value);

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
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
        if (index > size / 2) {
            Node<T> current = tail;
            for (int i = size; i > index + 1; i--) {
                current = current.prev;
            }
            return current.value;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    public boolean removeFirst() throws ListException {
        if (isEmpty()) throw new ListException("list is empty");

        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return true;
    }

    public boolean removeLast() throws ListException {
        if (isEmpty()) throw new ListException("list is empty");

        if (head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;

        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
