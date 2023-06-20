class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] answer = new int[nums.length];
        int window = 2 * k + 1;
        Arrays.fill(answer, -1);
        long runningSum = 0l;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            runningSum += nums[right];
            if (right - left + 1 == window) {
                long average = runningSum / window;
                answer[left + k] = (int) average;
                runningSum -= nums[left];
                left++;
            }
        }

        return answer;
    }
}
