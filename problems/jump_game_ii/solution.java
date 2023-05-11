class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Initialize all the index position with some max value to denote it is unreachable
            dp[i] = Integer.MAX_VALUE;
        }

        // Make the first position value as 0 as it is the default place where we start
        dp[0] = 0;
        // Main condition check goes here.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
