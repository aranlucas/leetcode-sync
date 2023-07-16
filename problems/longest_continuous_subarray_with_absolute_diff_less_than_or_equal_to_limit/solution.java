class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int left = 0;

        TreeSet<Integer> set =
                new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

        int longest = 1;
        for (int right = 0; right < nums.length; right++) {
            set.add(right);

            while (nums[set.last()] - nums[set.first()] > limit) {
                set.remove(left++);
            }
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
