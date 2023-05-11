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

    record Pair(TreeNode node, int index) {}
    ;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Pair> q = new LinkedList<>();

        int maxWidth = 0;
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair firstInLevel = q.getFirst();

            Integer currLevelSize = q.size();

            Pair curr = null;
            for (int i = 0; i < currLevelSize; ++i) {
                curr = q.removeFirst();
                TreeNode n = curr.node;
                if (curr.node.left != null) {
                    q.addLast(new Pair(n.left, 2 * curr.index));
                }
                if (curr.node.right != null) {
                    q.addLast(new Pair(n.right, 2 * curr.index + 1));
                }
            }
            maxWidth = Math.max(maxWidth, curr.index - firstInLevel.index + 1);
        }

        return maxWidth;
    }
}
