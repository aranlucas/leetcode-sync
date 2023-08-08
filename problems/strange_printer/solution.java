class Solution {
    public int strangePrinter(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return solve(s, 0, s.length() - 1, dp);
    }

    public int solve(String s, int i, int j, Integer[][] memo) {
        if (i == j) {
            return 1;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            ans = Math.min(ans, solve(s, i, k, memo) + solve(s, k + 1, j, memo));
        }

        return memo[i][j] = s.charAt(i) == s.charAt(j) ? ans - 1 : ans;
    }
}
