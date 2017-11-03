package leet.problem_297;

import leet.node.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Serialize_Deserialize_BT {
	
	public static void main(String args[]) {
		String data="1,2,4,5,3|4,2,5,1,3";
		TreeNode root = null;
	}
	
	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		result.append(inOrder(root), new StringBuilder());
	}
	private String inOrder(TreeNode node, StringBuilder result) {
		if(node == null)
			return null;
		inOrder(node.left, result);
		result.append(node.data);
		inOrder(node.right, result);
		return result.toString();
	}

}
