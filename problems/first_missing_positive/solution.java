class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        
        while (i < nums.length){
            
            int correctIdx = nums[i]-1;
            // If number is not in correctIdx
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIdx]){
                // Swap
                int tmp = nums[i];
                nums[i]= nums[correctIdx];
                nums[correctIdx] = tmp;
            } else {
                i++;
            }
        }
        
        
        for(int j = 0; j <nums.length; j++){
            if (nums[j] != j+1){
                return j+1;
            }
        }
        
        return nums.length + 1;
    }
}