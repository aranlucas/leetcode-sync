class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[nums.length][multipliers.length];
        return solve(0, 0, multipliers, nums, memo);
    }
    
    public int solve(int start, int multIndex, int[] multipliers, int[] nums, Integer[][] memo) {
        if (multIndex == multipliers.length) {
            return 0;
        }

        if (memo[start][multIndex] != null) {
            return memo[start][multIndex];
        }
        int end = nums.length - 1 - (multIndex - start);
        int begStart = solve(start + 1, multIndex + 1, multipliers, nums, memo) + nums[start] * multipliers[multIndex];
        int endStart = solve(start, multIndex + 1, multipliers, nums, memo) + nums[end] * multipliers[multIndex];
        return memo[start][multIndex] = Math.max(begStart, endStart);
    }
}