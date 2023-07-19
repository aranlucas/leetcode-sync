record Pair(int distance, int node) {}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Map<Integer, List<Pair>> graph = new HashMap<>();
        
        // create a weighted graph
        for (int i = 0; i < points.length; i++) {
            graph.put(i, new ArrayList<Pair>());
        }
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                if (i == j ) {
                    continue;
                }
                int distance = calculateManhattan(points[i][0], points[j][0], points[i][1], points[j][1]);
    
                graph.get(i).add(new Pair(distance, j));
                graph.get(j).add(new Pair(distance, i));
            }
        }
        
        // edge weight, the index of next node
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance() - b.distance());

        int len = points.length;

        boolean[] visited = new boolean[len];
        int cost = 0;
        pq.offer(new Pair(0, 0));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            
            Integer currNode = p.node();

            if (visited[currNode]) {
                continue;
            }

            visited[currNode] = true;
            cost += p.distance();
            
            for (Pair nextNodePair: graph.get(currNode)) {
                if (!visited[nextNodePair.node()]) {
                    pq.offer(nextNodePair);
                }
            }
        }
        
        return cost;
    }
    
    private int calculateManhattan(int x1, int x2, int y1, int y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}