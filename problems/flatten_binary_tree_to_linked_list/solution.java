// Time = O(N) because we traverse the whole binary tree
// space = O(N) because for a only left child binary tree. The call stack is O(N) 
class Solution {
    private TreeNode head;
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // postorder
        flatten(root.right);
        flatten(root.left);
        root.right = head;
        root.left = null;
        head = root;
    }
}