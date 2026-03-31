package tink.second_contest;

import java.util.Scanner;

public class TaskC {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static class Stack {
        private Node head;

        public void push(int val) {
            if (head == null) {
                head = new Node(val);
            } else {
                Node newNode = new Node(val);
                newNode.next = head;
                head = newNode;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int pop() {
            int val = head.val;
            head = head.next;
            return val;
        }
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();

        String line = sc.nextLine();
        for (String token : line.split(" ")) {
           if (token.matches("-?\\d")){
               stack.push(Integer.parseInt(token));
           }
           else{
               int b = stack.pop();
               int a = stack.pop();

               switch (token) {
                   case "+" -> stack.push(a + b);
                   case "-" -> stack.push(a - b);
                   case "*" -> stack.push(a * b);
               }
           }
        }
        sc.close();

        System.out.println(stack.pop());
    }

}
