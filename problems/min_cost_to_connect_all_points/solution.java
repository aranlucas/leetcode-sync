class Solution {
    public int minCostConnectPoints(int[][] points) {

        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();

        // create a weighted graph
        for (int i = 0; i < points.length; i++) {
            graph.put(i, new ArrayList<Pair<Integer, Integer>>());
        }

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance =
                        calculateManhattan(points[i][0], points[j][0], points[i][1], points[j][1]);

                graph.get(i).add(new Pair(distance, j));
                graph.get(j).add(new Pair(distance, i));
            }
        }

        // edge weight, the index of next node
        PriorityQueue<Pair<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

        int len = points.length;

        boolean[] visited = new boolean[len];
        int cost = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();

            Integer weight = p.getKey();
            Integer currNode = p.getValue();

            if (visited[currNode]) continue;

            visited[currNode] = true;
            cost += weight;

            for (Pair<Integer, Integer> nextNodePair : graph.get(currNode)) {
                Integer nextWeight = nextNodePair.getKey();
                Integer nextNode = nextNodePair.getValue();
                if (!visited[nextNode]) {
                    pq.offer(new Pair(nextWeight, nextNode));
                }
            }
        }

        return cost;
    }

    private int calculateManhattan(int x1, int x2, int y1, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
