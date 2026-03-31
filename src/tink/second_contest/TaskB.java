package tink.second_contest;

import java.util.*;
import java.io.*;

public class TaskB {

    static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    static class Stack {
        private Node head;

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val);
            } else {
                int currentMin = Math.min(val, head.min);
                Node newNode = new Node(val, currentMin);
                newNode.next = head;
                head = newNode;
            }
        }

        public int pop() {
            int val = head.val;
            head = head.next;
            return val;
        }

        public int getMin() {
            return head.min;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    static class Queue {
        private Stack stackIn = new Stack();
        private Stack stackOut = new Stack();

        public void enqueue(int val) {
            stackIn.push(val);
        }

        public int dequeue() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }

        public int getMin() {
            if (stackOut.isEmpty()) return stackIn.getMin();
            if (stackIn.isEmpty()) return stackOut.getMin();
            return Math.min(stackOut.getMin(), stackIn.getMin());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        if (line1 == null) return;

        StringTokenizer st = new StringTokenizer(line1);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue queue = new Queue();
        ArrayList<Integer> resultList = new ArrayList<>(n - k + 1);

        int count = 0;
        while (count < n) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer stNums = new StringTokenizer(line);
            while (stNums.hasMoreTokens() && count < n) {
                int val = Integer.parseInt(stNums.nextToken());

                if (count < k - 1) {
                    queue.enqueue(val);
                } else if (count == k - 1) {
                    queue.enqueue(val);
                    resultList.add(queue.getMin());
                } else {
                    queue.dequeue();
                    queue.enqueue(val);
                    resultList.add(queue.getMin());
                }
                count++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < resultList.size(); i++) {
            out.print(resultList.get(i));
            if (i < resultList.size() - 1) {
                out.print(" ");
            }
        }

        out.flush();
        out.close();
    }
}
