package leet.hard.problem_297;

import java.util.Stack;
import java.util.StringTokenizer;

import leet.node.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Serialize_Deserialize_BT {

	public static void main(String args[]) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(4);
		
		
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		
		//root.left = (new TreeNode(2));
		//root.right = (new TreeNode(2));

		// TreeNode root = null;
		Serialize_Deserialize_BT obj = new Serialize_Deserialize_BT();
		String serializedBT = obj.serialize(root);
		System.out.println(serializedBT);
		// TreeNode r = obj.deserialize(serializedBT);
		TreeNode r = obj.deserialize(obj.serialize(root));
		System.out.println(r.val);
	}

	// Encodes a tree to a single string.
	/**
	 * For the below binary tree
	 * 
	 *      10
	 *	   /   \
	 *	  5     40
	 *	 /  \      \
	 *	1    7      50
	 *	the serialize method would return
	 *	 
	 *  10,5,1,#,#,7,#,#,40,#,50,#,#
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			TreeNode h = stack.pop();
			if (h != null) {
				sb.append(h.val + ",");
				stack.push(h.right);
				stack.push(h.left);
			} else {
				sb.append("#,");
			}
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null)
			return null;
		int[] t = { 0 };
		String[] arr = data.split(",");
		return helper(arr, t);
	}

	public TreeNode helper(String[] arr, int[] t) {
		if (arr[t[0]].equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
		t[0] = t[0] + 1;
		root.left = helper(arr, t);
		t[0] = t[0] + 1;
		root.right = helper(arr, t);
		return root;
	}

}
