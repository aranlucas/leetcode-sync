class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int current = matrix[row][col];

                // 2 boundary conditions
                // left column -> no leftDiagonal
                if (col == 0) {
                    int down = dp[row + 1][col];
                    int rightDiagonal = dp[row + 1][col + 1];
                    dp[row][col] = Math.min(down, rightDiagonal) + current;
                    // right column -> no rightDiagonal
                } else if (col == matrix.length - 1) {
                    int down = dp[row + 1][col];
                    int rightDiagonal = dp[row + 1][col - 1];
                    dp[row][col] = Math.min(down, rightDiagonal) + current;
                } else {
                    int down = dp[row + 1][col];
                    int rightDiagonal = dp[row + 1][col + 1];
                    int leftDiagonal = dp[row + 1][col - 1];
                    dp[row][col] = Math.min(down, Math.min(leftDiagonal, rightDiagonal)) + current;
                }
            }
        }

        int minFallingSum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            minFallingSum = Math.min(minFallingSum, dp[0][i]);
        }
        return minFallingSum;
    }
}
