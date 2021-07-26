class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (var i = 1; i <= n - 1; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int result = 1;
        for (var i = n - 1; i >= 0; i--) {
            answer[i] = result * answer[i];
            result = result * nums[i];
        }

        return answer;
    }
}