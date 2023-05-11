class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, i, set);
        }

        List<List<Integer>> result = new ArrayList<>(set);

        return result;
    }

    public void twoSum(int[] nums, int i, Set<List<Integer>> set) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else if (sum == 0) {
                set.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
    }
}
