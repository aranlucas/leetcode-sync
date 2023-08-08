class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return solve(s.length() - 1, s, wordDict, memo);
    }

    public boolean solve(int i, String s, List<String> wordDict, Boolean[] memo) {
        if (i < 0) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        for (String word : wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }
            if (solve(i - word.length(), s, wordDict, memo)) {
                if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;

        return false;
    }
}
