package structures.trees;

import java.util.ArrayList;

import structures.exceptions.TreeException;

public class BinaryTree<T extends Comparable<T>> {

    private static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left;
        Node<T> right;
        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        int cmp = value.compareTo(current.value);

        if (cmp < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    };

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private boolean searchRecursive(Node<T> current, T value){
        if (current == null) return false;
        int cmp = value.compareTo(current.value);

        if (cmp == 0) return true;

        return cmp < 0
                ? searchRecursive(current.left, value)
                : searchRecursive(current.right, value);
    }

    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private void inorderWalk(Node<T> current, ArrayList<T> list) {
        if (current == null) return;
        inorderWalk(current.left, list);
        list.add(current.value);
        inorderWalk(current.right, list);
    }

    public ArrayList<T> inorder() {
        ArrayList<T> list = new ArrayList<>();
        inorderWalk(root, list);
        return list;
    }

    private void postorderWalk(Node<T> current, ArrayList<T> list) {
        if (current == null) return;
        postorderWalk(current.left, list);
        postorderWalk(current.right, list);
        list.add(current.value);
    }

    public ArrayList<T> postorder() {
        ArrayList<T> list = new ArrayList<>();
        postorderWalk(root, list);
        return list;
    }

    private void  preorderWalk(Node<T> current, ArrayList<T> list) {
        if (current == null) return;
        list.add(current.value);
        preorderWalk(current.left, list);
        preorderWalk(current.right, list);
    }

    public ArrayList<T> preorder() {
        ArrayList<T> list = new ArrayList<>();
        preorderWalk(root, list);
        return list;
    }

    private Node<T> getNode(Node<T> current, T value) {
        if (current == null) return null;
        int cmp = value.compareTo(current.value);
        if (cmp == 0) {
            return current;
        } else if (cmp < 0) {
            return getNode(current.left, value);
        }
        return getNode(current.right, value);
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
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            T minVal = getMin(current.right);
            current.value = minVal;

            current.right = deleteRecursive(current.right, minVal);
        }

        return current;
    }

    public void delete(T value) throws TreeException {
        root = deleteRecursive(root, value);
    }

}
