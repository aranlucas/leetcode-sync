class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}