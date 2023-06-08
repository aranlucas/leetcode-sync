class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        int majority = nums.length / 2;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;

                if (count > majority) {
                    return true;
                }
            }
        }

        return false;
    }
}