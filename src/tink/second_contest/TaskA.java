package tink.second_contest;
import java.util.*;
import java.io.*;

//стек с минимумом и ввод/вывод через буфер
//todo реализовать свой стек на любой тип данных
//где нибудь в src/structures

public class TaskA {

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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        Stack stack = new Stack();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());

            if (operation == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (operation == 2) {
                stack.pop();
            } else if (operation == 3) {
                res.add(stack.getMin());
            }
        }

        for (int i = 0; i < res.size(); i++) {
            out.println(res.get(i));
        }

        out.flush();
        out.close();
    }
}