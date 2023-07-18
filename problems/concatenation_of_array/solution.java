class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] answer  = new int[n * 2];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i];
            answer[i + n] = nums[i];
        }

        return answer;
    }
}