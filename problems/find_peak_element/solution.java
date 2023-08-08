class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int left = 1;
        int right = n - 1;

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid - 1] < nums[mid]) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
