class Solution {
    public int minCostClimbingStairs(int[] cost) {

        Integer[] memo = new Integer[cost.length + 1];
        return Math.min(solve(0, cost, memo), solve(1, cost, memo));
    }

    public int solve(int i, int[] cost, Integer[] memo) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        return memo[i] = cost[i] + Math.min(solve(i + 1, cost, memo), solve(i + 2, cost, memo));
    }
}