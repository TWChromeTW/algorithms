package structures.queues;

import structures.exceptions.ListException;
import structures.exceptions.QueueException;
import structures.lists.ListDoubleLinked;

public class DequeDoubleLinkedList<T> {

    private final ListDoubleLinked<T> list;

    public DequeDoubleLinkedList() {
        list = new ListDoubleLinked<>();
    }

    public void addFirst(T value) {
        list.addFirst(value);
    }

    public void addLast(T value) {
        list.addLast(value);
    }

    public T removeFirst() throws ListException {
        T value = list.getElement(0);
        list.removeFirst();
        return value;
    }

    public T removeLast() throws ListException {
        T value = list.getElement(list.size() - 1);
        list.removeLast();
        return value;
    }

    public T peekFirst() throws ListException {
        return list.getElement(0);
    }

    public T peekLast() throws ListException {
        return list.getElement(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
