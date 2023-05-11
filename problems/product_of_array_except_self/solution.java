class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[0] = 1;
        for (int i = 1; i < n; i++) {
            right[i] = nums[i - 1] * right[i - 1];
        }

        int[] left = new int[n];
        left[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            left[i] = nums[i + 1] * left[i + 1];
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
