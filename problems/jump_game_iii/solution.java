class Solution {
    public boolean canReach(int[] arr, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();


        for (int i = 0; i < arr.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + arr[i] < arr.length) {
                adj.get(i).add(i + arr[i]);
            }
            if (i - arr[i] >= 0) {
                adj.get(i).add(i - arr[i]);
            }
        }

        boolean[] visited = new boolean[arr.length];

        return dfs(start, adj, visited, arr);
    }

    public boolean dfs(int start, Map<Integer, List<Integer>> adj, boolean[] visited, int[] arr) {
        visited[start] = true;
        if (arr[start] == 0) {
            return true;
        }
        for (int neighbor: adj.get(start)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, arr)){
                    return true;
                }
            }
        }
        return false;
    }
}