class Solution {
    public int removeElement(int[] nums, int val) {
        int insertIdx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertIdx] = nums[i];
                insertIdx += 1;
            }
        }
        
        return insertIdx;
    }
}