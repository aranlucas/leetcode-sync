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
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        if (root == null){
            return levels;
        }
        
        helper(root, 0, levels);
        
        return levels;
        
    }
    
    public void helper(TreeNode node, int level, List<List<Integer>> levels){
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        
        levels.get(level).add(node.val);
        
        if (node.left != null){
            helper(node.left, level + 1, levels);
        }
        if (node.right != null){
            helper(node.right, level + 1, levels);
        }
    }
}