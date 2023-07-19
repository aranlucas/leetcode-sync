class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] grid) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Deque<List<Integer>> q = new ArrayDeque<>();
        path.add(0);
        q.add(path);

        while (!q.isEmpty()) {
            List<Integer> currentPath = q.removeFirst();
            int cur = currentPath.get(currentPath.size() - 1);
            if (cur == grid.length - 1) {
                answer.add(currentPath);
            }
            for (int nei : grid[cur]) {
                List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nei);
                q.add(tmpPath);
            }
        }
        return answer;
    }
}
