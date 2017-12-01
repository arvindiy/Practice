package leet.problem_2;

import leet.node.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode num1 = new ListNode(2);
		num1.next = new ListNode(4);
		num1.next.next = new ListNode(9);
		num1.next.next.next = new ListNode(9);

		ListNode num2 = new ListNode(5);
		num2.next = new ListNode(6);
		num2.next.next = new ListNode(1);

		AddTwoNumbers obj = new AddTwoNumbers();
		obj.printList(num1);
		System.out.println();
		obj.printList(num2);
		System.out.println();
		System.out.println("-----------");

		ListNode sum = obj.addTwoNumbers(num1, num2);
		obj.printList(sum);

	}

	public void printList(ListNode n) {
		while (n != null) {
			System.out.print(n.val + "   ");
			n = n.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null, prev = null;
		int carry = 0, sum = 0;
		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			ListNode tmp = new ListNode(sum);
			if (result == null) {
				result = tmp;
			} else {
				prev.next = tmp;
			}
			prev = tmp;
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null)
			addRest(l1, carry, prev);
		else if (l2 != null)
			addRest(l2, carry, prev);
		else if (carry != 0) {
			prev.next = new ListNode(1);
		}
		return result;
	}

	private void addRest(ListNode node, int carry, ListNode prev) {

		while (node != null) {
			int sum = node.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			prev.next = new ListNode(sum);
			node = node.next;
			prev = prev.next;
		}
		if (carry > 0) {
			prev.next = new ListNode(1);
		}

	}
}
