class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++)
                result.add(i);
            
            return result;
        }
        

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            indegrees[b]++;
            graph.get(b).add(a);
            indegrees[a]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 1) {
                q.addLast(i);
            }
        }
        int remainingNodes = n;

        List<Integer> result = new ArrayList<>();
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();
                indegrees[cur]--;


                for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    indegrees[nei]--;

                    if (indegrees[nei] == 1) {
                        q.add(nei);
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            result.add(q.poll()); 
        }

        return result;
    }
}