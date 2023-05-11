class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int response = nums[0];

        for (int i = 1; i <= nums.length - 1; i++) {
            int choice1 = minProduct * nums[i];
            int choice2 = maxProduct * nums[i];
            maxProduct = Math.max(nums[i], Math.max(choice1, choice2));
            minProduct = Math.min(nums[i], Math.min(choice1, choice2));
            response = Math.max(maxProduct, response);
        }

        return response;
    }
}
