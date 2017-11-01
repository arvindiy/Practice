package algo;

import leet.node.TreeNode;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeftNode(new TreeNode(2));
		root.getLeftNode().setLeftNode(new TreeNode(4));
		root.getLeftNode().setRightNode(new TreeNode(5));
		root.setRightNode(new TreeNode(3));
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
		inOrder(node.getLeftNode());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRightNode());
	}

	private void postOrder(TreeNode node) {

		if (node == null)
			return;
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getValue() + " ");
	}

	private void preOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
	}

}
