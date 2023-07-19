class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<String>()).add(to);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    public void dfs(
            String departure,
            Map<String, PriorityQueue<String>> graph,
            LinkedList<String> itinerary) {
        PriorityQueue<String> arrivals = graph.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), graph, itinerary);
        }
        itinerary.addFirst(departure);
    }
}
