class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int sum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int num : nums) {
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);

            sum += num;
        }

        if (sum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, sum - minSum);
    }
}