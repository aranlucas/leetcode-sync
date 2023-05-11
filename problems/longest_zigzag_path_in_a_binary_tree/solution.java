/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int traverse(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return steps - 1;
        }
        if (goLeft) {
            int a = traverse(node.left, false, steps + 1);
            int b = traverse(node.right, true, 1);
            return Math.max(a, b);
        }
        int a = traverse(node.left, false, 1);
        int b = traverse(node.right, true, steps + 1);
        return Math.max(a, b);
    }

    public int longestZigZag(TreeNode root) {
        return traverse(root, false, 0);
    }
}
