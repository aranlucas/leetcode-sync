class Solution {

  public int longestCommonSubsequence(String text1, String text2) {

    int[][] memo = new int[text1.length()][text2.length()];
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    int result = helper(0, 0, text1, text2, memo);
    return result;
  }

  public int helper(int i, int j, String text1, String text2, int[][] memo) {
    if (i >= text1.length() || j >= text2.length()) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    if (text1.charAt(i) == text2.charAt(j)) {
      return memo[i][j] = helper(i + 1, j + 1, text1, text2, memo) + 1;
    } else {
      return memo[i][j] =
          Math.max(helper(i + 1, j, text1, text2, memo), helper(i, j + 1, text1, text2, memo));
    }
  }
}
