class Solution {
    record Pair(int id, int time) {}

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curManager = manager[i];
            if (curManager >= 0) {
                graph.computeIfAbsent(curManager, k -> new ArrayList<>());
                graph.get(curManager).add(i);
            }
        }

        Deque<Pair> employee = new ArrayDeque<>();

        employee.addLast(new Pair(headID, 0));

        int minutes = 0;
        while (!employee.isEmpty()) {
            Pair curr = employee.removeFirst();
            minutes = Math.max(minutes, curr.time);

            for (int sub : graph.getOrDefault(curr.id, new ArrayList<>())) {
                employee.addLast(new Pair(sub, curr.time + informTime[curr.id]));
            }
        }

        return minutes;
    }
}
