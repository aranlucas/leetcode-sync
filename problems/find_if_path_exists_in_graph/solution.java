class Solution {
  public boolean validPath(int n, int[][] edges, int source, int destination) {

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

    // Store all the nodes to be visited in 'queue'.
    boolean[] seen = new boolean[n];
    Deque<Integer> queue = new ArrayDeque();

    queue.offer(source);
    seen[source] = true;
    while (!queue.isEmpty()) {
      int currNode = queue.poll();

      if (currNode == destination) {
        return true;
      }

      for (int nextNode : graph.get(currNode)) {
        if (!seen[nextNode]) {
          seen[nextNode] = true;
          queue.offer(nextNode);
        }
      }
    }
    return false;
  }
}
