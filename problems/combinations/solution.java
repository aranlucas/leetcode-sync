class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(1, n, k, current, answer);

        return answer;
    }

    private void backtrack(
            int start, int n, int k, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
