//task number from leetcode 2807

package leet_code;

public class InsGreatCommonDivInLinkList {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int nod(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if (a >= b) return nod(a % b, b);
        return nod(a, b % a);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            int nodVal = nod(current.val, current.next.val);
            ListNode newNode = new ListNode(nodVal, current.next);
            current.next = newNode;
            current = current.next.next;
        }

        return head;
    }

}
