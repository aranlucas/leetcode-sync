class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return curMax - curMin;
        }
        int newCurMax = Math.max(curMax, node.val);
        int newCurMin = Math.min(curMin, node.val);
        int left = helper(node.left, newCurMax, newCurMin);
        int right = helper(node.right, newCurMax, newCurMin);
        return Math.max(left, right);
    }
}
