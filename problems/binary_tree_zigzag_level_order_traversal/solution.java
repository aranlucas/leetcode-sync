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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        boolean isReversed = true;

        while (!q.isEmpty()) {
            ArrayList<Integer> innerList = new ArrayList<>();

            int size = q.size();

            while (size > 0) {
                TreeNode current = q.poll();
                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }

                innerList.add(current.val);
                size--;
            }

            if (!isReversed) {
                Collections.reverse(innerList);
            }

            list.add(innerList);

            isReversed = !isReversed;
        }
        return list;
    }
}