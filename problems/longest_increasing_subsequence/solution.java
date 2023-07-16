class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return solve(-1, 0, nums, memo);
    }

    public int solve(int prev, int curr, int[] nums, Integer[][] memo) {
        if (curr == nums.length) {
            return 0;
        }

        if (memo[prev + 1][curr] != null) {
            return memo[prev + 1][curr];
        }

        int take = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            // Use curr in sequence
            take = 1 + solve(curr, curr + 1, nums, memo);
        }

        // Don't use this number in sequence
        int noTake = solve(prev, curr + 1, nums, memo);

        int answer = Math.max(take, noTake);
        return memo[prev + 1][curr] = answer;
    }
}
