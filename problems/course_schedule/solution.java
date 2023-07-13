class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            adj.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int nodesVisited = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            nodesVisited++;
            for (int neighbor : adj.get(node)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}