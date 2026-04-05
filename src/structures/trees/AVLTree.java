package structures.trees;

import structures.exceptions.TreeException;

public class AVLTree<T extends Comparable<T>> {

    private static class Node<T> {
        T value;
        int height;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    private void swap(Node<T> a, Node<T> b) {
        T tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node<T> balanceNode(Node<T> node) {
        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                node.left = leftRotation(node.left);
            }
            return rightRotation(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rightRotation(node.right);
            }
            return leftRotation(node);
        }

        return node;
    }
    
    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        int cmp = value.compareTo(current.value);

        if (cmp < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, value);
        } else {
            return current;
        }

        updateHeight(current);

        return balanceNode(current);
    };

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> rightRotation(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<T> leftRotation(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private T getMin(Node<T> current) {
        if (current.left == null) return current.value;
        return getMin(current.left);
    }
    
    private Node<T> deleteRecursive(Node<T> current, T value) throws TreeException {
        if (current == null) return null;

        int cmp = value.compareTo(current.value);

        if (cmp < 0) {
            current.left = deleteRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = deleteRecursive(current.right, value);
        } else {
            if (current.left == null || current.right == null) {
                current = (current.left != null) ? current.left : current.right;
            } else {
                T minVal = getMin(current.right);
                current.value = minVal;
                current.right = deleteRecursive(current.right, minVal);
            }
        }

        if (current == null) return null;
        return balanceNode(current);
    }

    public void delete(T value) throws TreeException {
        root = deleteRecursive(root, value);
    }
    
}
