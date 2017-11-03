package leet.problem_297;

import java.util.StringTokenizer;

import leet.node.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Serialize_Deserialize_BT {

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);

		/*root.left = (new TreeNode(2));
		root.left.left = (new TreeNode(4));
		root.left.right = (new TreeNode(5));
		root.right = (new TreeNode(3));*/
		root.left = (new TreeNode(2));
		root.right = (new TreeNode(2));

		// TreeNode root = null;
		Serialize_Deserialize_BT obj = new Serialize_Deserialize_BT();
		// String serializedBT = obj.serialize(root);
		// System.out.println(serializedBT);
		// TreeNode r = obj.deserialize(serializedBT);
		TreeNode r = obj.deserialize(obj.serialize(root));
		System.out.println(r.val);
	}

	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();

		String s = inOrder(root, new StringBuilder());
		result.append(s == null ? "" : s);
		result.append("|");
		s = preOrder(root, new StringBuilder());
		result.append(s == null ? "" : s);

		return result.toString();
	}

	public TreeNode deserialize(String data) {
		TreeNode root = null;
		if (data == null) {
			return root;
		}

		StringTokenizer tokenizer = new StringTokenizer(data, "|");
		int[] preOrder = null;
		int[] inOrder = null;
		if (tokenizer.countTokens() == 2) {
			String inOrder_Str = tokenizer.nextToken();
			String preOrder_Str = tokenizer.nextToken();
			StringTokenizer inTokenizer = new StringTokenizer(inOrder_Str, ",");
			StringTokenizer preTokenizer = new StringTokenizer(preOrder_Str, ",");
			inOrder = new int[inTokenizer.countTokens()];
			preOrder = new int[preTokenizer.countTokens()];
			for (int i = 0; i < inOrder.length; i++) {
				preOrder[i] = Integer.parseInt(preTokenizer.nextToken());
				inOrder[i] = Integer.parseInt(inTokenizer.nextToken());
			}
			root = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		}
		return root;
	}

	private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		if (preEnd < preStart || inEnd < inStart)
			return null;

		int value = preOrder[preStart];
		int index = -1;
		for (int i = 0; i < inOrder.length; i++) {
			if (value == inOrder[i]) {
				index = i;
				break;
			}
		}

		TreeNode node = new TreeNode(value);

		node.left = buildTree(preOrder, preStart + 1, preStart + (index - inStart), inOrder, inStart, index - 1);
		node.right = buildTree(preOrder, preStart + (index - inStart) + 1, preEnd, inOrder, index + 1, inEnd);
		return node;
	}

	private String inOrder(TreeNode node, StringBuilder result) {
		if (node == null)
			return null;
		inOrder(node.left, result);
		result.append(result.toString().length() == 0 ? "" : ",").append(node.val);
		inOrder(node.right, result);
		return result.toString();
	}

	private String preOrder(TreeNode node, StringBuilder result) {
		if (node == null)
			return null;
		result.append(result.toString().length() == 0 ? "" : ",").append(node.val);
		inOrder(node.left, result);
		inOrder(node.right, result);
		return result.toString();
	}

}
