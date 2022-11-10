class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list

        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        dijkstra(signalReceivedAt, k, n, adj);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dijkstra(int [] signalReceivedAt, int source, int n, Map<Integer, List<Pair<Integer, Integer>>> graph) {               
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((a , b) -> a.getKey()- b.getKey());
        
        pq.add(new Pair(0, source));
        
        // Time for starting node is 0
        signalReceivedAt[source] = 0;
        
        while (!pq.isEmpty()) {
            var topPair = pq.remove();
            
            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();
            
            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            
            if (!graph.containsKey(currNode)) {
                continue;
            }
            
            for (var edge: graph.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                
                int newTime = currNodeTime + time;
                
                if (signalReceivedAt[neighborNode] > newTime) {
                    signalReceivedAt[neighborNode] = newTime;
                    pq.add(new Pair(newTime, neighborNode));
                }
            }
        }
    }
}