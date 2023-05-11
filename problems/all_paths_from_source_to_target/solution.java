class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    int target = graph.length - 1;
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    path.addLast(0);

    backtrack(0, path, graph, target, result);

    return result;
  }

  public void backtrack(
      int currNode,
      LinkedList<Integer> path,
      int[][] graph,
      int target,
      List<List<Integer>> result) {
    if (currNode == target) {
      result.add(new ArrayList<Integer>(path));
      return;
    }

    for (int nextNode : graph[currNode]) {
      path.add(nextNode);
      backtrack(nextNode, path, graph, target, result);
      path.removeLast();
    }
  }
}
