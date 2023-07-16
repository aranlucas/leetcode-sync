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
    record Pair(boolean uni, int count) {}

    public int countUnivalSubtrees(TreeNode root) {
        return dfs(root).count();
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int currentCount = left.count + right.count;

        if (left.uni && right.uni) {
            if (root.left != null && root.val != root.left.val) {
                return new Pair(false, currentCount);
            }

            if (root.right != null && root.val != root.right.val) {
                return new Pair(false, currentCount);
            }
            currentCount++;
            return new Pair(true, currentCount);
        }

        return new Pair(false, currentCount);
    }
}
