class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int numZeroes = 0;
        int consecutive = 0;
        int maxConsecutive = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                numZeroes++;
            }
            
            while (numZeroes == 2) {
                if (nums[windowStart] == 0) {
                    numZeroes--;
                }
                windowStart++;
            }
            maxConsecutive = Math.max(maxConsecutive, windowEnd - windowStart + 1);
        }
        
        return maxConsecutive;
    }
}