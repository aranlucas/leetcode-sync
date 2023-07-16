class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // l     m     r
            // [4,5,6,7,0,1,2]
            // Array is sorted on left side
            if (nums[left] <= nums[mid]) {
                // Start searching.
                // if [left] < target < [middle] then do recursion with left, middle - 1 (right)
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Sorted right side
                // if [middle] < target < [right] then do recursion with middle + 1 (left), right
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
