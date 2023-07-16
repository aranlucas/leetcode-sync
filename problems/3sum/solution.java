class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> intermediate = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[lo++]);
                    r.add(nums[hi--]);
                    intermediate.add(r);
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return new ArrayList<>(intermediate);
    }
}
