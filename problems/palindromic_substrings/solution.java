class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];

        if (n <= 0) {
            return 0;
        }

        // single letter substrings
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            ans++;
        }

        // 2 letter substring
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        // controls the size of the substring
        for (int len = 2; len < n; len++) {
            // controls the start index
            for (int i = 0; i + len < n; i++) {
                int j = i + len; // end index
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
