package leet.problem_508;

//https://leetcode.com/problems/most-frequent-subtree-sum/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import leet.node.TreeNode;

public class MostFrequentSubtreeSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);
		new MostFrequentSubtreeSum().findFrequentTreeSum(root);

	}

	public int[] findFrequentTreeSum(TreeNode node) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		postOrderSum(node, map);
		int count = 0;
		int max = 0;
		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			int sum = iter.next();
			int value = map.get(sum);
			if (max < value) {
				max = value;
				count = 1;
			} else if (max == value) {
				count++;
			}
		}
		
		int[] retVal = new int[count];
		int i =0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			int sum = (int) iterator.next();
			if(max == map.get(sum)) {
				retVal[i++] = sum;
			}
			
		}		
		return retVal;
	}

	private int postOrderSum(TreeNode node, HashMap<Integer, Integer> map) {
		if (node == null)
			return 0;
		int sum = postOrderSum(node.left, map) + postOrderSum(node.right, map) + node.val;
		Integer value = map.get(sum);
		if (value != null) {
			map.put(sum, value + 1);
		} else {
			map.put(sum, 1);
		}
		return sum;
	}
}
