class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int[] result = new int[nums.length];
        
        int evenIdx = 0;
        int oddIdx = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[evenIdx++] = nums[i];
            } else {
                result[oddIdx--] = nums[i];
            }
        }
        
        return result;
    }
}