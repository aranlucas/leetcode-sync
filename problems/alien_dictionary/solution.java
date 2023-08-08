class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                indegrees.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char a = word1.charAt(j);
                char b = word2.charAt(j);

                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return "";
                }
                if (a != b) {
                    graph.get(a).add(b);
                    indegrees.put(b, indegrees.get(b) + 1);
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();

        for (var entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q.addLast(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.removeFirst();
            sb.append(cur);
            for (Character nei : graph.getOrDefault(cur, new ArrayList<>())) {
                indegrees.put(nei, indegrees.get(nei) - 1);

                if (indegrees.get(nei) == 0) {
                    q.addLast(nei);
                }
            }
        }
        if (sb.length() != indegrees.size()) {
            return "";
        }
        return sb.toString();
    }
}
