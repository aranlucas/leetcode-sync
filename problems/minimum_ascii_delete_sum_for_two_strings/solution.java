class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Integer[][] memo = new Integer[n][m];
        return solve(s1, s2, 0, 0, memo);
    }

    public int solve(String s1, String s2, int i, int j, Integer[][] memo) {
        if (i == s1.length()) {
            int deleteCost = 0;

            for (int k = j; k < s2.length(); k++) {
                deleteCost += s2.charAt(k);
            }
            return deleteCost;
        }

        if (j == s2.length()) {
            int deleteCost = 0;
            for (int k = i; k < s1.length(); k++) {
                deleteCost += s1.charAt(k);
            }

            return deleteCost;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return solve(s1, s2, i + 1, j + 1, memo);
        }

        int moveS1 = s1.charAt(i) + solve(s1, s2, i + 1, j, memo);
        int moveS2 = s2.charAt(j) + solve(s1, s2, i, j + 1, memo);
        int moveBoth = s1.charAt(i) + s2.charAt(j) + solve(s1, s2, i + 1, j + 1, memo);

        return memo[i][j] = Math.min(moveS1, Math.min(moveS2, moveBoth));
    }
}
