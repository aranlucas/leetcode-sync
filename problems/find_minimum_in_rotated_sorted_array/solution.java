class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (right >= left) {
            int midpoint = left + (right - left) / 2;

            if (nums[midpoint] > nums[midpoint + 1]) {
                return nums[midpoint + 1];
            }

            if (nums[midpoint - 1] > nums[midpoint]) {
                return nums[midpoint];
            }

            if (nums[midpoint] > nums[0]) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1;
    }
}