class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    // When left is null
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    // When left is up is null
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j != 0 && i != 0) {
                    // All other happy cases
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
