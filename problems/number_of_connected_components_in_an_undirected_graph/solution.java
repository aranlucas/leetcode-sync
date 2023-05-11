class Solution {
  public int countComponents(int n, int[][] edges) {
    // Store all edges in 'graph'.
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }

    // Compute adjacency list
    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    Set<Integer> visited = new HashSet();

    int components = 0;
    // using keySet() for iteration over keys
    for (int node : graph.keySet()) {
      if (!visited.contains(node)) {
        components++;
        dfs(graph, node, visited);
      }
    }
    return components;
  }

  public void dfs(Map<Integer, List<Integer>> graph, int startNode, Set<Integer> visited) {
    visited.add(startNode);

    var neighbors = graph.get(startNode);

    for (int neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        dfs(graph, neighbor, visited);
      }
    }
  }
}
