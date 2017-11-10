package leet.problem_449;

import java.util.Stack;

import leet.node.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-bst/description/

/**
 * This problem can have multiple implementations 1. We can serialize the tree
 * using inorder/preorder and deserialize it using those two orders 2. We can
 * serialize the tree using just preorder, and deserialize using the inorder 3.
 * We can serialize using level order traversal, and build the tree
 * (deserialize) from that level order traversal
 * 
 * @author akrishnaniyer
 *
 */

public class Serialize_Deserialize_BST {

	public static void main(String[] args) {
		// TreeNode root = null;
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);

		root.right = new TreeNode(40);
		root.right.left = null;
		root.right.right = new TreeNode(50);
		Serialize_Deserialize_BST obj = new Serialize_Deserialize_BST();
		String data = obj.serialize(root);
		System.out.println(data);
		System.out.println(obj.deserialize(data));

	}

	// Encodes a tree to a single string, in preorder traversal
	
	/**
	 * For the below binary search tree
	 * 
	 *      10
	 *	   /   \
	 *	  5     40
	 *	 /  \      \
	 *	1    7      50
	 *	the serialize method would return
	 *	 
	 * 10,5,1,7,40,50,
	 * 
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}

	private void preOrder(TreeNode x, StringBuilder sb) {
		if (x == null)
			return;
		sb.append(x.val).append(",");
		preOrder(x.left, sb);
		preOrder(x.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;

		String[] nodes = data.split(",");
		int[] values = new int[nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			values[i] = Integer.parseInt(nodes[i]);
		}
		TreeNode root = buildTree(values, 0, nodes.length - 1);
		return root;
	}

	private TreeNode buildTree(int[] preOrder, int lo, int hi) {
		//Base Case
		if (lo > hi)
			return null;
		int val = preOrder[lo]; 
		// root value;
		TreeNode node = new TreeNode(val);
		if (lo == hi)
			return node;

		int rightChild = -1;
		/*
		 * In the following loop, we find the next larger element
		 * in the array. If we hit it, then starting that index
		 * the right subtree starts
		 * If there is no element larger than val, no right sub tree exists
		 * and only the left subtree needs creation.
		 * */
		for (int i = lo + 1; i <= hi; i++) {
			if (val < preOrder[i]) {
				//Found a greater element. 
				//Set as the right child start index.
				rightChild = i;
				break;
			}
		}

		if (rightChild == -1)
			node.left = buildTree(preOrder, lo + 1, hi);
		else if (rightChild > lo) {
			node.left = buildTree(preOrder, lo + 1, rightChild - 1);
			node.right = buildTree(preOrder, rightChild, hi);
		}

		return node;
	}
}
