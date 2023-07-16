class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;

        int subArrayLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // If sum is greater than target, try to window smaller
            while (sum >= target) {
                subArrayLength = Math.min(subArrayLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return subArrayLength == Integer.MAX_VALUE ? 0 : subArrayLength;
    }
}
