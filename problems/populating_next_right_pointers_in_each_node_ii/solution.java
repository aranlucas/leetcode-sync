/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> q = new LinkedList<>();

        q.addLast(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = q.removeFirst();

                if (prev != null) {
                    prev.next = cur;
                }

                if (cur.left != null) {
                    q.addLast(cur.left);
                }

                if (cur.right != null) {
                    q.addLast(cur.right);
                }

                prev = cur;
            }
        }

        return root;
    }
}
