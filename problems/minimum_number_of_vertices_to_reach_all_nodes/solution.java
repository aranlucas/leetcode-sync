class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegrees = new int[n];

        for (List<Integer> edge: edges) {
            int b = edge.get(1); // 1

            indegrees[b] += 1;
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                answer.add(i);
            }
        }

        return answer;
    }
}