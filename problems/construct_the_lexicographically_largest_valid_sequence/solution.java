class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] sol = new int[(2 * n) - 1];
        boolean[] visited = new boolean[n + 1];
        backtrack(0, sol, visited, n);
        return sol;
    }

    private boolean backtrack(int i, int[] sol, boolean[] visited, int n) {
        if (i == sol.length) {
            return true;
        }

        if (sol[i] != 0) {
            return backtrack(i + 1, sol, visited, n);
        }

        for (int j = n; j > 0; j--) {
            if (!visited[j] && (j == 1 || i + j < sol.length && sol[i + j] == 0)) {
                sol[i] = j;
                if (j != 1) {
                    sol[i + j] = j;
                }

                visited[j] = true;

                if (backtrack(i + 1, sol, visited, n)) {
                    return true;
                }

                sol[i] = 0;

                if (j != 1) {
                    sol[i + j] = 0;
                }

                visited[j] = false;
            }
        }
        return false;
    }
}
