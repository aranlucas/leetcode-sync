class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        // Total sum using formula
        int total = nums.length * (nums.length + 1) / 2;

        // Add all numbers in array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // Diference is the missing number
        return total - sum;
    }
}
