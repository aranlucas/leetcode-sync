class Solution {
  public String alienOrder(String[] words) {
    // Step 0: Create data structures and find all unique letters.
    Map<Character, List<Character>> adjList = new HashMap<>();
    Map<Character, Integer> indegrees = new HashMap<Character, Integer>();

    for (String word : words) {
      for (char c : word.toCharArray()) {
        indegrees.put(c, 0);
        adjList.put(c, new ArrayList<>());
      }
    }

    // Find edges
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }
      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          adjList.get(word1.charAt(j)).add(word2.charAt(j));
          indegrees.put(word2.charAt(j), indegrees.get(word2.charAt(j)) + 1);
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    Deque<Character> queue = new ArrayDeque();

    System.out.println(indegrees);
    for (Character c : indegrees.keySet()) {
      if (indegrees.get(c).equals(0)) {
        queue.offer(c);
      }
    }

    while (!queue.isEmpty()) {
      Character c = queue.poll();
      sb.append(c);

      for (Character neighbor : adjList.get(c)) {
        indegrees.put(neighbor, indegrees.get(neighbor) - 1);
        if (indegrees.get(neighbor).equals(0)) {
          queue.offer(neighbor);
        }
      }
    }
    if (sb.length() < indegrees.size()) {
      return "";
    }
    return sb.toString();
  }
}
