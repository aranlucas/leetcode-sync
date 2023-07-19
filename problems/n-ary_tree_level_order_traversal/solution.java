/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Node> q = new ArrayDeque<>();

        q.addLast(root);
        List<List<Integer>> answers = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node cur = q.removeFirst();
                level.add(cur.val);

                for (Node nei : cur.children) {
                    if (nei == null) {
                        continue;
                    }
                    q.addLast(nei);
                }
            }
            answers.add(level);
        }

        return answers;
    }
}
