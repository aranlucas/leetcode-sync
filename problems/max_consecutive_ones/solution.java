class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currentConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentConsecutive += 1;
            } else {
                currentConsecutive = 0;
            }
            maxConsecutive = Math.max(maxConsecutive, currentConsecutive);            
        }
        
        return maxConsecutive;
    }
}