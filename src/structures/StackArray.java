package structures;

import structures.exceptions.StackException;

public class StackArray<T> {
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public StackArray(int capacity) {
        stackArray = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T item) throws StackException {
        if (top == stackArray.length - 1) throw new StackException("Stack overflow");
        stackArray[++top] = item;
    }

    public T pop() throws StackException {
        if (top == -1) throw new StackException("Stack underflow");
        return stackArray[top--];
    }

    public T peek() throws StackException {
        if (top == -1) throw new StackException("Stack is empty");
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
