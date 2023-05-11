class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];

        prefix[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int sum = 0;

        for (int start = 0; start < prefix.length; start++) {
            for (int end = start + 1; end < prefix.length; end++) {
                if (prefix[end] - prefix[start] == k) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
