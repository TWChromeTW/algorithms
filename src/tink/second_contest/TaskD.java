package tink.second_contest;

import java.util.Scanner;

public class TaskD {
    static class Node {
        int val;
        int count;
        Node next;

        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    static class Stack {
        private Node head;

        public void push(int val, int count) {
            if (head == null) {
                head = new Node(val, count);
            } else {
                Node newNode = new Node(val, count);
                newNode.next = head;
                head = newNode;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int[] pop() {
            int val = head.val;
            int count = head.count;
            int[] res = new int[2];
            res[0] = val;
            res[1] = count;
            head = head.next;
            return res;
        }

        public int[] peek() {
            int val = head.val;
            int count = head.count;
            int[] res = new int[2];
            res[0] = val;
            res[1] = count;
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st = new Stack();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        st.push(m, 1);

        for (int i = 0; i < n - 1; i++) {
            int newVal = sc.nextInt();

            if (st.isEmpty()) {
                break;
            }

            int[] head = st.pop();

            if (head[0] == newVal) {
                st.push(newVal, head[1] + 1);
            }
            else {
                if (head[1] > 2) {
                    count += head[1];
                    if (!st.isEmpty()) {
                        int[] newHead = st.peek();
                        if (newHead[0] == newVal) {
                            st.pop(); // убираем старую верхушку
                            st.push(newVal, newHead[1] + 1);
                        } else {
                            st.push(newVal, 1);
                        }
                    } else {
                        st.push(newVal, 1);
                    }
                }
                else{
                    st.push(head[0], head[1]);
                    st.push(newVal, 1);
                }

            }
        }

        while (!st.isEmpty()) {
            int[] head = st.pop();
            if (head[1] >= 3) {
                count += head[1];
            }
        }

        System.out.println(count);
    }
}
