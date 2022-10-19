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
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    public boolean inorder(TreeNode node){
        if (node == null) {
            return true;    
        }
        
        if(!inorder(node.left)){
            return false;
        }
        System.out.print(node.val + " ");
        
        if (prev != null && node.val <= prev) {
            return false;
        }
        
        prev = node.val;

        return inorder(node.right);
    }
}