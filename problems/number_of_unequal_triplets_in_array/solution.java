class Solution {
    public int unequalTriplets(int[] nums) {
        int triplets = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k] && i<j && j<k && i<k){
                        triplets++;
                    }
                }
            }
        }
        return triplets;
    }
}