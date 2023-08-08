class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        //  j  i
        // [10,9,2,5,3,7,101,18]
        for (int cur = 1; cur < nums.length; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (nums[cur] > nums[prev]) {
                    if (dp[cur] < dp[prev] + 1) {
                        dp[cur] = dp[prev] + 1;
                    }
                }
            }
        }

        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        return longest;
    }
}
