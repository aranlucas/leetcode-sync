class Solution {
    int[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<int[]> jobs = new ArrayList();
        memo = new int[startTime.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new int[] {startTime[i], endTime[i], profit[i]});
        }

        // Arrays.sort(list, (a, b)-> a[0]- b[0]);
        jobs.sort((a1, a2) -> a1[0] - a2[0]);

        jobs.forEach(
                (l) -> {
                    System.out.println(Arrays.toString(l));
                });

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < profit.length; i++) {
            startTime[i] = jobs.get(i)[0];
        }

        return findMaxProfit(jobs, 0);
    }

    private int findMaxProfit(List<int[]> jobs, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == jobs.size()) {
            return 0;
        }
        if (memo[position] != -1) return memo[position];

        int nextIndex = -1;

        for (int i = position + 1; i < jobs.size(); i++) {
            if (jobs.get(i)[0] >= jobs.get(position)[1]) {
                nextIndex = i;
                break;
            }
        }

        int include = jobs.get(position)[2];
        if (nextIndex != -1) {
            include += findMaxProfit(jobs, nextIndex);
        }

        int exclude = findMaxProfit(jobs, position + 1);
        int maxProfit = Math.max(include, exclude);

        memo[position] = maxProfit;
        return memo[position];
    }
}
