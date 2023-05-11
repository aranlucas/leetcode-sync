/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List root1Leaf = new ArrayList<Integer>();
        List root2Leaf = new ArrayList<Integer>();
        dfs(root1, root1Leaf);
        dfs(root2, root2Leaf);

        return root1Leaf.equals(root2Leaf);
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result.add(node.val);
        }

        dfs(node.left, result);
        dfs(node.right, result);
    }
}
