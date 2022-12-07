class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // System.out.println(i + " " + j);
                // System.out.println(s.substring(j, i));
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // System.out.println(Arrays.toString(dp));
                }
            }
        }
        return dp[s.length()];
    }

}