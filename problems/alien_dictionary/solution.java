class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }

        Map<Character, List<Character>> graph = new HashMap<>();

        Map<Character, Integer> indegrees = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char a = w1.charAt(j);
                char b = w2.charAt(j);

                if (a != b) {
                    graph.get(a).add(b);
                    indegrees.put(b, indegrees.getOrDefault(b, 0) + 1);
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();

        for (var entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        StringBuilder sortedOrder = new StringBuilder();

        while (!q.isEmpty()) {
            char cur = q.removeFirst();
            sortedOrder.append(cur);

            for (char nei : graph.getOrDefault(cur, new ArrayList<>())) {
                indegrees.put(nei, indegrees.get(nei) - 1);

                if (indegrees.get(nei) == 0) {
                    q.addLast(nei);
                }
            }
        }

        if (sortedOrder.length() != indegrees.size()) {
            return "";
        }

        return sortedOrder.toString();
    }
}
