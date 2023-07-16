class Solution {
    int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        Integer[][] memo = new Integer[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(dfs(i, j, matrix, memo), answer);
            }
        }

        System.out.println(Arrays.deepToString(memo));
        return answer;
    }

    public int dfs(int x, int y, int[][] matrix, Integer[][] memo) {

        if (memo[x][y] != null) {
            return memo[x][y];
        }

        int answer = 1;
        for (int[] dir : DIRS) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            if (dx >= 0 && dx < matrix.length && dy >= 0 && dy < matrix[0].length) {
                if (matrix[dx][dy] > matrix[x][y]) {
                    answer = Math.max(1 + dfs(dx, dy, matrix, memo), answer);
                }
            }
        }

        return memo[x][y] = answer;
    }
}
