class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] bomb1 = bombs[i];
                int[] bomb2 = bombs[j];

                if ((long) bomb1[2] * bomb1[2] >= (long) (bomb1[0] - bomb2[0]) * (bomb1[0] - bomb2[0]) + (long)(bomb1[1] - bomb2[1]) * (bomb1[1] - bomb2[1])) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(cur);
        int count = 1;
        for (int nei: graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(nei)) {
                count += dfs(nei, visited, graph);
            }
        }
        return count;
    }
}


/**

if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
}
 */