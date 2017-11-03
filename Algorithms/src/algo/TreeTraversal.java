package algo;

import leet.node.TreeNode;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left =(new TreeNode(2));
		root.left.left = (new TreeNode(4));
		root.left.right = (new TreeNode(5));
		root.right  = (new TreeNode(3));
		TreeTraversal tt = new TreeTraversal();
		System.out.println("Inorder Traversal...");
		tt.inOrder(root);
		System.out.println();
		System.out.println("Postorder Traversal...");
		tt.postOrder(root);
		System.out.println();
		System.out.println("Preorder Traversal...");
		tt.preOrder(root);
	}

	private void inOrder(TreeNode node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

	private void postOrder(TreeNode node) {

		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}

	private void preOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

}
