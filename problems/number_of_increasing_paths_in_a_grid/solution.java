class Solution {
    int mod = 1_000_000_007;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newAnswer = dfs(grid, i, j, dp);
                answer = (newAnswer + answer) % mod;
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int x, int y, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        int answer = 1;

        for (int[] d : directions) {
            int dx = x + d[0];
            int dy = y + d[1];

            if (0 <= dx && dx < grid.length && 0 <= dy && dy < grid[0].length) {
                if (grid[dx][dy] < grid[x][y]) {
                    answer += dfs(grid, dx, dy, dp);
                    answer %= mod;
                }
            }
        }

        return dp[x][y] = answer;
    }
}