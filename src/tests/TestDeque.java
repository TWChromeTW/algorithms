package tests;

import structures.queues.Deque;

public class TestDeque {

    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);
        deque.addLast(10);

        deque.show();

        System.out.println();
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

//        deque.reverse();
//        deque.show();
    }

}
