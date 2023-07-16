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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);

        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();
                l.add(cur.val);
                if (cur.left != null) {
                    q.addLast(cur.left);
                }

                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            result.add(l);
        }

        return result;
    }
}
