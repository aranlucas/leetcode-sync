class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = profit.length;
        List<int[]> jobsWithProfit = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            jobsWithProfit.add(new int[] {startTime[i], endTime[i], profit[i]});
        }

        Collections.sort(jobsWithProfit, (a, b) -> a[0] - b[0]);
        Integer[] memo = new Integer[n];
        return solve(jobsWithProfit, 0, memo);
    }

    public int solve(List<int[]> jobsWithProfit, int curJobIndex, Integer[] memo) {
        if (curJobIndex == jobsWithProfit.size()) {
            return 0;
        }

        if (memo[curJobIndex] != null) {
            return memo[curJobIndex];
        }

        int skipJob = solve(jobsWithProfit, curJobIndex + 1, memo);

        int[] curJob = jobsWithProfit.get(curJobIndex);

        int takeJob = curJob[2];
        for (int nextJob = curJobIndex + 1; nextJob < jobsWithProfit.size(); nextJob++) {
            if (curJob[1] <= jobsWithProfit.get(nextJob)[0]) {
                takeJob += solve(jobsWithProfit, nextJob, memo);
                break;
            }
        }

        return memo[curJobIndex] = Math.max(skipJob, takeJob);
    }
}
