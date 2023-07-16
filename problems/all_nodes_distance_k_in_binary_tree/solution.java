/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

        traverse(root, null, graph);

        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        q.add(target);
        visited.add(target);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (level == k) {
                    answer.add(cur.val);
                }
                for (TreeNode nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.addLast(nei);
                    }
                }
            }
            level++;
        }

        return answer;
    }

    public void traverse(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node != null && parent != null) {
            graph.putIfAbsent(node, new ArrayList<>());
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }

        if (node != null && node.left != null) {
            traverse(node.left, node, graph);
        }
        if (node != null && node.right != null) {
            traverse(node.right, node, graph);
        }
    }
}
