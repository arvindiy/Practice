package leet;

import leet.node.TreeNode;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

public class Binary_Tree_Construction_From_Pre_Order_And_In_Order {

	public static void main(String[] args) {
		int[] preOrder = { 1, 2, 4, 5, 3 };
		int[] inOrder = { 4, 2, 5, 1, 3 };
		TreeNode root = new Binary_Tree_Construction_From_Pre_Order_And_In_Order().buildTree(preOrder, inOrder);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length)
			return null; // Pre order and inorder are of different trees, if the lengths are not the
							// same;
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
	}

	private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {

		if (preStart < preEnd || inStart < inEnd)
			return null;

		int value = preOrder[preStart];
		TreeNode node = new TreeNode(value);
		int index = -1;
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == value) {
				index = i;
				break;
			}
		}

		node.setLeftNode(buildTree(preOrder, preStart + 1, preStart + (index - inStart), inOrder, inStart, index - 1));
		node.setRightNode(buildTree(preOrder, preStart + (index - inStart) + 1, preEnd, inOrder, index + 1, inEnd));

		return node;
	}

}
