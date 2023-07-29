class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        int missing = 0;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                missing = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[0] + k + missing;
    }
}