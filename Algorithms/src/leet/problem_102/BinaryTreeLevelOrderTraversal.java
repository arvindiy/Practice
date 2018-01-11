package leet.problem_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet.node.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		if(root == null)
			return returnList;
		//Iterative metod
		Queue<TreeNode> q = new LinkedList<TreeNode>();		
		q.add(root);
		while(true) {
			int nodeCount = q.size();
			if(nodeCount == 0)
				break;
			
			List<Integer> levelNodes = new ArrayList<Integer>();
			while(nodeCount > 0) {
				TreeNode n = q.poll();
				levelNodes.add(n.val);
				if(n.left != null) 
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
				nodeCount--;
			}
			returnList.add(levelNodes);
		}
		return returnList;
	}

}
