package leet.medium.problem_102;

import leet.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * This method would do level order traversal of a binary tree.
     * Following are the steps
     * 1. Create a queue
     * 2. Add the root node
     * 3. Initialize an integer variable to the size of the queue
     * 4. Iterate until the integer is > 0
     * 5. Remove an element
     * 6. Add the left and right children (if not null) to the queue, of the removed element
     * 7. Decrement the integer.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        if (root == null)
            return returnList;
        //Iterative method
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            List<Integer> levelNodes = new ArrayList<Integer>();
            while (nodeCount > 0) {
                TreeNode n = q.poll();
                levelNodes.add(n.val);
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
                nodeCount--;
            }
            returnList.add(levelNodes);
        }
        return returnList;
    }

}
