package leet.problem_652;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leet.node.TreeNode;

//https://leetcode.com/problems/find-duplicate-subtrees/description/

public class DuplicateSubtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new LinkedList<>();
		postorder(root, new HashMap<>(), res);
		return res;
	}

	private String postorder(TreeNode curr, Map<String, Integer> map, List<TreeNode> res) {
		if (curr == null)
			return "#";
		String serial = curr.val + "," + postorder(curr.left, map, res) + "," + postorder(curr.right, map, res);
		if (map.getOrDefault(serial, 0) == 1)
			res.add(curr);
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}

}
