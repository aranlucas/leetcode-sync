class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            var map = adj.computeIfAbsent(manager[i], k -> new ArrayList<>());
            if (manager[i] != -1) {
                map.add(i);
            }
        }

        return dfs(adj, informTime, headID);
    }

    int dfs(Map<Integer, List<Integer>> adj, int[] informTime, int curr) {
        int maxTime = 0;

        for (int nei: adj.getOrDefault(curr, new ArrayList<>())) {
            maxTime = Math.max(dfs(adj, informTime, nei), maxTime);
        }

        return maxTime + informTime[curr];
    }
}