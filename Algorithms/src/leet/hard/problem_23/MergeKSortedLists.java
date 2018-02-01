package leet.hard.problem_23;

//https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/

import leet.node.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		/*
		 * Create a priority queue which stores the values based on the value
		 * in the linked list node.
		 */
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val)
					return 1;
				else if (o1.val < o2.val)
					return -1;
				else
					return 0;
			}
		});

		//Create a non-moving dummy head node.
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		//Create another node, which would move with new elements being added
		ListNode tail = dummy;
		
		//Add all the list head nodes to the priority queue
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}

		//Iterate until the priority queue is empty
		while (!pq.isEmpty()) {
			/*
			 * When we poll the pq, it would remove the element on top of the queue
			 * and rearrange the queue.
			 */
			tail.next = pq.poll();
			//Move the tail node to the newly added node above
			tail = tail.next;
			/*
			 * If this list has another element, we add that also to the pq.
			 */
			if (tail.next != null) {
				pq.add(tail.next);
			}
		}
		
		/*
		 * Once all the nodes are added, dummy becomes the head of the resultant list,
		 * the actual head would be the next node to dummy.
		 */
		return dummy.next;
	}

}
