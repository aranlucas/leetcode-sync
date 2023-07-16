class Solution {
    record Pair(int edge, double probability) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int to = edge[0];
            int from = edge[1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Pair(from, pathProb));
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Pair(to, pathProb));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));

        pq.add(new Pair(start, 1.0));
        Set<Integer> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.edge == end) {
                return cur.probability;
            }
            if (seen.contains(cur.edge)) {
                continue;
            }
            seen.add(cur.edge);
            for (Pair neighbor : graph.getOrDefault(cur.edge, new ArrayList<>())) {
                pq.add(new Pair(neighbor.edge, neighbor.probability * cur.probability));
            }
        }
        return 0d;
    }
}
