class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge: prerequisites) {
            int dest = edge[0];
            int src = edge[1];
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            indegrees[dest]++;
        }

        Deque<Integer> q = new ArrayDeque<>();


        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                indegrees[nei]--;

                if (indegrees[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (answer.size() == numCourses) {
            return answer.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}