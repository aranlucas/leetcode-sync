class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int left = 0;

        int length = 0;
        for (int right = 0; right < nums.length; right++) {

            if (right > 0 && nums[right - 1] >= nums[right]) {
                left = right;
            }

            length = Math.max(right - left + 1, length);
        }

        return length;
    }
}
