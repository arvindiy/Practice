package leet.problem_173;

import leet.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BSTIterator {
    Queue<Integer> q;
    TreeNode root;

    /**
     * add all the elements to a queue, in preorder
     * Inorder of a BST will be ascending order.
     * dequeueing from a queue will return the next smallest element.
     *
     * @param root
     */
    public BSTIterator(TreeNode root) {
        if (root == null)
            return;
        this.root = root;
        q = new LinkedList<Integer>();
        traverse(root, q);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * Create an inorder traversal
     *
     * @param root
     * @param queue
     */
    public void traverse(TreeNode root, Queue<Integer> queue) {
        if (root == null)
            return;
        traverse(root.left, queue);
        queue.add(root.val);
        traverse(root.right, queue);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return q != null && !q.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (q == null)
            return 0;
        return q.poll();
    }

}
