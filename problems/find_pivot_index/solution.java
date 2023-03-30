class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
                
        int sum = prefixSum[nums.length]; 
        for (int i = 0; i < nums.length; i++) {
            int leftSum = prefixSum[i];
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}