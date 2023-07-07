class Solution {
    int[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<int[]> jobs = new ArrayList<>();
        memo = new int[startTime.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new int[] {startTime[i], endTime[i], profit[i]});
        }
        
        // Arrays.sort(list, (a, b)-> a[0]- b[0]);
        jobs.sort((a , b) -> a[0] - b[0]);
        
        return findMaxProfit(jobs, 0);
    }
    
    private int findMaxProfit(List<int[]> jobs, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position >= jobs.size()) {
            return 0;
        }
        
        if (memo[position]!=-1) {
            return memo[position];
        }

        int k = position + 1;

        while (k < jobs.size() && jobs.get(k)[0] < jobs.get(position)[1]) {
            k++;
        }
        
        int include = jobs.get(position)[2] + findMaxProfit(jobs, k);
        int exclude = findMaxProfit(jobs, position + 1);        
        
        return memo[position] = Math.max(include, exclude);
    }
}