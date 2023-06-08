class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] memo = new double[n];
        return solve(n, k, maxPts, 0, memo);
    }

    private double solve(int n, int k, int maxPts, int cur, double[] memo) {
        if (cur == k - 1) {
            return (double) Math.min(n - k + 1, maxPts) / maxPts;
        }
        if (cur > n) {
            return 0.0;
        }
        if (cur >= k) {
            return 1.0;
        }

        if (memo[cur] != 0) {
            return memo[cur];
        }

        double prob =
                solve(n, k, maxPts, cur + 1, memo)
                        - (solve(n, k, maxPts, cur + 1 + maxPts, memo)
                                        - solve(n, k, maxPts, cur + 1, memo))
                                / maxPts;

        return memo[cur] = prob;
    }
}
