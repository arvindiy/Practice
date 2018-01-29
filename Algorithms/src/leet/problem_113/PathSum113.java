package leet.problem_113;

import leet.node.TreeNode;

//https://leetcode.com/problems/path-sum/description/

/**
 *
 * @author akrishnaniyer
 */
public class PathSum113 {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
	}

	/**
	 * A straightforward tree traversal flow, attempting to find the leaf node,
	 * which adds up to the target sum, from the root node.
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null && root.val - sum == 0)
			return true;

		return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));

	}

}