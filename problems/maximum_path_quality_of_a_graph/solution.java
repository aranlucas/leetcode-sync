class Solution {
    int answer = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, time);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, time);
        }
        answer = values[0];
        int[] seen = new int[values.length];
        dfs(0, graph, values, seen, maxTime, 0);
        return answer;
    }

    public void dfs(int node, Map<Integer, Map<Integer, Integer>> graph, int[] values, int[] seen, int maxTime, int quality) {
        seen[node]++;

        if (seen[node] == 1) {
            quality += values[node];
        }

        if (node == 0) {
            answer = Math.max(answer, quality);
        }

        for (var nei : graph.getOrDefault(node, new HashMap<>()).entrySet()) {
            int newTime = nei.getValue();
            if (newTime <= maxTime) {
                dfs(nei.getKey(), graph, values, seen, maxTime - newTime, quality);
            }
        }
        seen[node]--;
    }
}