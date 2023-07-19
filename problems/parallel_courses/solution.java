class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];

            graph.get(prev).add(next);
            indegrees[next]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.addLast(i);
            }
        }
        int result = 0, finishedCourses = 0; 

        while (!q.isEmpty()) {
            finishedCourses += q.size();
            int size = q.size();
            result++;
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    indegrees[nei]--;
                    if (indegrees[nei] == 0) {
                        q.addLast(nei);
                    }
                }
            }
        }

        return finishedCourses == n ? result : -1;
    }
}