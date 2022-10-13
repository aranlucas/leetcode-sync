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
    public void constructPaths(TreeNode root, String path, List<String> paths){
        if(root!= null){
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null)){
                paths.add(path);
            } else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList();
        constructPaths(root, "", paths);
        return paths;
    }
}