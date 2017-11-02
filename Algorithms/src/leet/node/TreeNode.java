package leet.node;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public int getValue() {
		return this.val;
	}
	
	public TreeNode getLeftNode() {
		return this.left;
	}
	public TreeNode getRightNode() {
		return this.right;
	}
	
	public void setLeftNode(TreeNode left) {
		this.left = left;
	}
	public void setRightNode(TreeNode right) {
		this.right = right;
	}
}
