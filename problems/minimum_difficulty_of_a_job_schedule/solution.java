class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }
        Integer[][] memo = new Integer[n][d + 1];
        return solve(0, d, jobDifficulty, memo);
    }

    public int solve(int i, int daysRemaining, int[] jobDifficulty, Integer[][] memo) {
        if (memo[i][daysRemaining] != null) {
            return memo[i][daysRemaining];
        }

        if (daysRemaining == 1) {
            int res = 0;

            for (int j = i; j < jobDifficulty.length; j++) {
                res = Math.max(res, jobDifficulty[j]);
            }
            return res;
        }

        int res = Integer.MAX_VALUE;
        int dailyMaxJobDiff = 0;

        for (int j = i; j < jobDifficulty.length - daysRemaining + 1; j++) {
            dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j]);
            res =
                    Math.min(
                            res,
                            dailyMaxJobDiff + solve(j + 1, daysRemaining - 1, jobDifficulty, memo));
        }

        memo[i][daysRemaining] = res;
        return res;
    }
}
