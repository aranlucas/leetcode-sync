class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }

        return solve(piles, dp, 0, 0, 1);
    }

    private int solve(int[] piles, int[][][] dp, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[p][i][m] != -1) {
            return dp[p][i][m];
        }

        int s = 0;
        int res = p == 1 ? 1000000 : -1;

        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];

            if (p == 0) {
                res = Math.max(res, s + solve(piles, dp, 1, i + x, Math.max(m, x)));
            } else {
                res = Math.min(res, solve(piles, dp, 0, i + x, Math.max(m, x)));
            }
        }

        return dp[p][i][m] = res;
    }
}
