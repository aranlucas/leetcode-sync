class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;

            // If mid is in bounds && greater than next number. Ex: 1 < 5
            //      l m r
            // [3,4,5,1,2]
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // If mid is greater than right, search on right side
            //  l   m   r
            // [3,4,5,1,2]
            //      l m r
            // [3,4,5,1,2]
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}