package leet.medium.problem_109;

import leet.node.ListNode;
import leet.node.TreeNode;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

public class ConvertLinkedListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {

		return toBST(head, null);

	}

	public TreeNode toBST(ListNode head, ListNode tail) {
		// Start the fast and slow pointers at the head
		ListNode slow = head;
		ListNode fast = head;
		/*
		 * Move the fast node two nodes at a time, and the slow pointer one node at a
		 * time
		 * 
		 * Once the fast node reaches the end, slow would be in the middle The middle
		 * node would be the root node left subtree of this node would be from head to
		 * the slow node right subtree would be from slow.next to the tail
		 */
		while (fast != tail || fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = toBST(head, slow);
		node.right = toBST(slow.next, tail);
		return node;
	}

}
