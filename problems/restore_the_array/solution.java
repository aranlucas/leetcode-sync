class Solution {
    int mod = (int) 1e9 + 7;
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return dfs(dp, 0, s, k);
    }

    private int dfs(int[] dp, int start, String s, int k) {
        if (dp[start] != 0) {
            return dp[start];
        }

        if (start == s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int count = 0;

        for (int end = start; end < s.length(); end++) {
            String currNumber = s.substring(start, end + 1);
            if (Long.parseLong(currNumber) > k) {
                break;
            }
            count = (count + dfs(dp, end + 1, s, k)) % mod;
        }

        return dp[start] = count;
    }
}