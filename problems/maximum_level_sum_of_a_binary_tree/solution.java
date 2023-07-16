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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int ans = 0;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();

                levelSum += cur.val;

                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }

            if (maxSum < levelSum) {
                maxSum = levelSum;
                ans = level;
            }
        }

        return ans;
    }
}
