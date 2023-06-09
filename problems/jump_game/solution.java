class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j <= nums[i] + i; j++) {
                if (dp[j]) {
                    dp[i] = dp[j];
                    break;
                }
            }
        }

        return dp[0];
    }
}
