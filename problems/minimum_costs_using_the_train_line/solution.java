class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        Long[][] dp = new Long[n][2];
        solve(n - 1, 1, regular, express, expressCost, dp);

        long[] ans = new long[regular.length];
        // Store cost for each stop.
        for (int i = 0; i < regular.length; i++) {
            ans[i] = dp[i][1];
        }

        return ans;
    }

    public long solve(
            int i, int lane, int[] regular, int[] express, int expressCost, Long[][] memo) {

        if (i < 0) {
            return 0;
        }

        if (memo[i][lane] != null) {
            return memo[i][lane];
        }

        long regularLane = regular[i] + solve(i - 1, 1, regular, express, expressCost, memo);
        long expressLane =
                (lane == 1 ? expressCost : 0)
                        + express[i]
                        + solve(i - 1, 0, regular, express, expressCost, memo);

        return memo[i][lane] = Math.min(regularLane, expressLane);
    }
}
