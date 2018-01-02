package leet.problem_23;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/

import leet.node.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {
		
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val)
					return 1;
				else if(o1.val < o2.val)
					return -1;
				else
					return 0;
			}			
		});
		
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode tail = dummy;
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null)
				pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			if(tail.next != null) {
				pq.add(tail.next);
			}
		}		
		return dummy.next;
	}

}
