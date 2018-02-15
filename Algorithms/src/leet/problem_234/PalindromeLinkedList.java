package leet.problem_234;

//https://leetcode.com/problems/palindrome-linked-list/description/

//TODO

import leet.node.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Even length list
        // 1 -> 2 -> 4-> 4 -> 2 -> 1
        ListNode evenHead = new ListNode(1);
        evenHead.next = new ListNode(2);
        evenHead.next.next = new ListNode(4);
        evenHead.next.next.next = new ListNode(4);
        evenHead.next.next.next.next = new ListNode(2);
        evenHead.next.next.next.next.next = new ListNode(1);

        // Odd length list
        // 1 -> 2 -> 5 -> 2 -> 1
        ListNode oddHead = new ListNode(1);
        oddHead.next = new ListNode(2);
        oddHead.next.next = new ListNode(5);
        oddHead.next.next.next = new ListNode(2);
        oddHead.next.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkedList().isPalindrome(evenHead));
    }

    /**
     * 1. Push the first half of the linked list into a stack 2. Begin at the middle
     * of the list, and compare each element with stack.pop() 3. If all elements are
     * same, its a palindrome
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(stack.toString());
        System.out.println(slow.val);

        /*
         * If fast is null, its an even length list. Slow is one element past the
         * middle. If fast.next is null, its an odd length list Slow is the middle of
         * the list.
         */
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int val = stack.pop();
            if (slow.val != val)
                return false;
            slow = slow.next;
        }

        return true;
    }
}
