class Solution {
    int[][] KNIGHT_MOVES = {{2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] dp = new Double[k + 1][n][n];

        double answer = solve(n, k, row, column, dp);

        return answer;
    }

    public double solve(int n, int moves, int row, int column, Double[][][] dp) {
        if (moves == 0) {
            return 1;
        }

        if (dp[moves][row][column] != null) {
            return dp[moves][row][column];
        }

        double prob = 0;
        for (int[] dir: KNIGHT_MOVES) {
            int dx = row + dir[0];
            int dy = column + dir[1];
            if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                prob += solve(n, moves - 1, dx, dy, dp);
            }
        }

        return dp[moves][row][column] = prob / 8.0;
    }
}