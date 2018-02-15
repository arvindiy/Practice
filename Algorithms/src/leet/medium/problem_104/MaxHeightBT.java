package leet.medium.problem_104;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

import leet.node.TreeNode;

public class MaxHeightBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        /*
         * root.left = (new TreeNode(2)); root.left.left = (new TreeNode(4));
         * root.left.right = (new TreeNode(5)); root.right = (new TreeNode(3));
         */
        root.left = (new TreeNode(2));
        root.right = (new TreeNode(2));
        System.out.println(new MaxHeightBT().maxDepth(root));
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = maxDepth(node.left) + 1;
        int rightHeight = maxDepth(node.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }
}
