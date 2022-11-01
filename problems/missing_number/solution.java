class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {
            int num = nums[i];
            
            if (num < nums.length && num != i) {
                swap(nums, i, num);
            } else {
                i++;
            }
        }
        
        // search for first missing number using linear search
        for (int index = 0;index < nums.length; index++){
            if (nums[index]!= index) {
                return index;
            }
        }
        return nums.length;
    }
    
    private void swap(int arr[], int first, int second){
        //simple swap algorithm
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}