package leet.problem_235;

import leet.node.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LowestCommonAncestorOfABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		else return root;
	}

}
