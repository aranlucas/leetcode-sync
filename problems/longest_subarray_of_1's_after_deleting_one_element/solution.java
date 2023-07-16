class Solution {
    public int longestSubarray(int[] nums) {

        int longestSubarray = 0;
        int left = 0;

        int replacement = 1;
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            if (incoming == 0) {
                replacement--;
            }
            while (replacement < 0) {
                int outgoing = nums[left];
                if (outgoing == 0) {
                    replacement++;
                }
                left++;
            }
            longestSubarray = Math.max(longestSubarray, right - left);
        }

        return longestSubarray;
    }
}
