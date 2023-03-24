class Solution {
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();

        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            // Real edges
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(Arrays.asList(to, 1));
            // "Fake" edges
            adjList.putIfAbsent(to, new ArrayList<>());
            adjList.get(to).add(Arrays.asList(from, 0));
        }
        boolean[] visited = new boolean[n];
        return dfs(0, visited, adjList);
    }

    public int dfs(int node, boolean[] visited, Map<Integer, List<List<Integer>>> adj) {
        int change = 0;
        visited[node] = true;
        for (List<Integer> nei : adj.get(node)) {
            int child = nei.get(0);
            int sign = nei.get(1);
            if (!visited[child]) {
                change += sign + dfs(child, visited, adj);
            }
        }

        return change;
    }
}