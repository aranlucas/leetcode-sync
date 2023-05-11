class Solution {
    Integer[][][] memo = new Integer[101][101][101];

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        return solve(0, 0, 0, n, minProfit, group, profits);
    }

    public int solve(
            int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        int mod = (int) 1e9 + 7;
        if (pos == group.length) {
            return profit >= minProfit ? 1 : 0;
        }

        if (memo[pos][count][profit] != null) {
            // Repeated subproblem, return the stored answer.
            return memo[pos][count][profit];
        }

        // Skip crime
        int totalWays = solve(pos + 1, count, profit, n, minProfit, group, profits);

        // Take Job if we can (Do we still have members left?)
        if (count + group[pos] <= n) {
            // Total group members doing job
            int newCount = count + group[pos];
            // less profit needed if we take job
            int profitStillNeeded = Math.min(minProfit, profit + profits[pos]);
            totalWays += solve(pos + 1, newCount, profitStillNeeded, n, minProfit, group, profits);
        }

        return memo[pos][count][profit] = totalWays % mod;
    }
}
