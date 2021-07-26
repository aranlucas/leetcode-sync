class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = max;
        for (var i = 1; i <= nums.length - 1; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}