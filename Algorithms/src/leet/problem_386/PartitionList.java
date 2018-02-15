package leet.problem_386;

import leet.node.ListNode;

public class PartitionList {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = head, right = head;
        if (head == null)
            return null;
        while (right.next != null) {
            if (right.val >= x) {
                int tmp = right.val;
                right.val = left.val;
                left.val = right.val;
                right = right.next;
            }
            left = left.next;
        }
        return head;
    }

}
