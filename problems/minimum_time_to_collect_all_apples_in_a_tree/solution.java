class Solution {
  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      adj.computeIfAbsent(a, v -> new ArrayList<Integer>()).add(b);
      adj.computeIfAbsent(b, v -> new ArrayList<Integer>()).add(a);
    }

    return dfs(0, -1, adj, hasApple);
  }

  public int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
    // Base case
    if (!adj.containsKey(node)) {
      return 0;
    }

    int totalTime = 0;

    for (int child : adj.get(node)) {
      if (child == parent) {
        continue;
      }

      int childTime = dfs(child, node, adj, hasApple);
      if (childTime > 0 || hasApple.get(child)) {
        totalTime += childTime + 2;
      }
    }

    return totalTime;
  }
}
