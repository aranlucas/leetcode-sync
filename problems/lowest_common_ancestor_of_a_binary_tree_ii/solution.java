/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> found = new HashSet<>();
        TreeNode node = dfs(root, p, q, found);
        return found.size() == 2 ? node : null;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q, Set<Integer> found) {
        if (root == null) return null;
        TreeNode l = dfs(root.left, p, q, found);
        TreeNode r = dfs(root.right, p, q, found);
        if (root.val == p.val || root.val == q.val) {
            found.add(root.val);
            return root;
        }
        // If two target nodes are on separate branches, LCA is the root.
        if (l != null && r != null) return root;
        // one node is on one branch or none was found in both branches.
        return l != null ? l : r;
    }
}
