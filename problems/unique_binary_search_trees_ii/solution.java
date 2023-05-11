/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new LinkedList<TreeNode>();
    }

    return helper(1, n);
  }

  private LinkedList<TreeNode> helper(int start, int end) {
    LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();

    // Base case
    if (start > end) {
      allTrees.add(null);
      return allTrees;
    }

    for (int i = start; i <= end; i++) {
      LinkedList<TreeNode> left = helper(start, i - 1);
      LinkedList<TreeNode> right = helper(i + 1, end);
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode c = new TreeNode(i);
          c.left = l;
          c.right = r;
          allTrees.add(c);
        }
      }
    }

    return allTrees;
  }
}
