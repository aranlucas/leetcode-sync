class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();


        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();

        seen.add(source);
        q.addLast(source);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            if (cur == destination) {
                return true;
            }
            for (int nei : graph.get(cur)) {
                if (seen.contains(nei)) {
                    continue;
                }
                seen.add(nei);
                q.addLast(nei);
            }
        }

        return false;
    }
}