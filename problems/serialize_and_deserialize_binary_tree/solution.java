/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    List<String> result = new ArrayList();

    Deque<TreeNode> queue = new LinkedList();

    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        result.add("n");
        continue;
      }

      result.add(String.valueOf(node.val));
      queue.offer(node.left);
      queue.offer(node.right);
    }

    return String.join(",", result);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == "n") return null;
    Deque<TreeNode> q = new LinkedList<>();
    String[] values = data.split(",");
    if (values[0].equals("n")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    q.add(root);

    for (int i = 1; i < values.length; i++) {
      TreeNode parent = q.poll();
      if (!values[i].equals("n")) {
        TreeNode left = new TreeNode(Integer.parseInt(values[i]));
        parent.left = left;
        q.add(left);
      }
      i++;

      if (!values[i].equals("n")) {
        TreeNode right = new TreeNode(Integer.parseInt(values[i]));
        parent.right = right;
        q.add(right);
      }
    }
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
