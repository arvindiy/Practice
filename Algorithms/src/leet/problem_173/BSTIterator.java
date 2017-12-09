package leet.problem_173;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import leet.node.TreeNode;
//https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BSTIterator {
	Queue<Integer> q;
	TreeNode root;

	public BSTIterator(TreeNode root) {
		if (root == null)
			return;
		this.root = root;
		q = new LinkedList<Integer>();
		traverse(root, q);
	}

	public void traverse(TreeNode root, Queue<Integer> queue) {
		if (root == null)
			return;
		traverse(root.left, queue);
		queue.add(root.val);
		traverse(root.right, queue);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return q != null && !q.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (q == null)
			return 0;
		return q.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
