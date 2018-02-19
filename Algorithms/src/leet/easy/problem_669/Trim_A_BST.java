package leet.easy.problem_669;
//https://leetcode.com/problems/trim-a-binary-search-tree/description/

import leet.node.TreeNode;

public class Trim_A_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * this is a recursive implementation of the trimming algorithm
	 * we can also implement it another way
	 * 
	 * 1. Traverse in preorder (sorted output)
	 * 2. Take only those nodes that are between L & R
	 * 3. Construct a BST from this section of the sorted array.
	 * 
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		
		/*
		 * If the root value is greater than L,
		 * the two limits lie on the right side of the root node 
		 */
		if (root.val > L)
			return trimBST(root.right, L, R);
		/*if the root value is lesser than the R value,
		 * the two limit values lie on the left side of the root node
		 */
		if (root.val < R)
			return trimBST(root.right, L, R);

		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}

}
