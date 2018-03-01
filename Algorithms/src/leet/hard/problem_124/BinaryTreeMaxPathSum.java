package leet.hard.problem_124;

import leet.node.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class BinaryTreeMaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * These are the possibilities 1. Node + LeftMax 2. Node + RightMax 3. Node +
	 * LeftMax + RightMax 4. Node
	 */
	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		findMax(root, max);
		return max[0];
	}

	public int findMax(TreeNode node, int[] max) {
		if (node == null) {
			return 0;
		}
		int left = findMax(node.left, max);
		int right = findMax(node.right, max);
		max[0] = Math.max(max[0], node.val + left + right);
		int retVal = node.val + Math.max(left, right);
		return retVal > 0 ? retVal : 0;
	}
}
