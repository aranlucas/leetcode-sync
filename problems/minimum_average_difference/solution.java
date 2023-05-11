class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;

        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            long leftPartAverage = prefixSum[i + 1] / (i + 1);

            long rightPartAverage = suffixSum[i + 1];
            if (i != n - 1) {
                rightPartAverage = rightPartAverage / (n - i - 1);
            }

            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);

            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = i;
            }
        }
        return ans;
    }
}
